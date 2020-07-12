//
// Created by Ciaran on 5/31/2020.
//

#include "RDF.h"

#include <utility>


namespace omexmeta {


    RDF::RDF(const std::string &storage_type, const std::string &storage_name,
             const char *storage_options, const char *model_options) {
        storage_ = LibrdfStorage(storage_type, storage_name, storage_options);
        // model_ now owns storage_
        model_ = LibrdfModel(storage_.get(), model_options);
    }

    void RDF::freeRDF() {
        model_.freeModel();
        storage_.freeStorage();
    }

    RDF::~RDF() {
        freeRDF();
    }

    RDF::RDF(RDF &&rdf) noexcept {
        namespaces_ = std::move(rdf.namespaces_);
        seen_namespaces_ = std::move(rdf.seen_namespaces_);
        default_namespaces_ = std::move(rdf.default_namespaces_);
        storage_ = std::move(rdf.storage_);
        model_ = std::move(rdf.model_);
    }

    RDF &RDF::operator=(RDF &&rdf) noexcept {
        if (this != &rdf) {
            namespaces_ = std::move(rdf.namespaces_);
            seen_namespaces_ = std::move(rdf.seen_namespaces_);
            default_namespaces_ = std::move(rdf.default_namespaces_);
            storage_ = std::move(rdf.storage_);
            model_ = std::move(rdf.model_);
        }
        return *this;
    }

    int RDF::size() const {
        return model_.size();
    }

    bool RDF::empty() const {
        return size() == 0;
    }

    RDF RDF::fromString(const std::string &str, const std::string &format, const std::string &base_uri) {
        RDF rdf;
        LibrdfParser parser(format);
        LibrdfUri u = LibrdfUri::fromFilename(base_uri);
        parser.parseString(str, rdf.model_, u);
        u.freeUri();

        // update the list of "seen" namespaces
        rdf.seen_namespaces_ = parser.getSeenNamespaces();

        // Compare against predefined set of namespaces: bqbiol etc.
        // This allows us to only use the ones that are needed
        rdf.namespaces_ = rdf.propagateNamespacesFromParser(rdf.seen_namespaces_);

        return rdf;
    }

    void RDF::fromString(RDF *rdf, const std::string &str, const std::string &format, std::string base_uri) {
        // if the base_uri is a web uri we leave it alone
        base_uri = OmexMetaUtils::prepareBaseUri(base_uri);

        LibrdfParser parser(format);
        parser.parseString(str, rdf->model_, LibrdfUri(base_uri));

        // update the list of "seen" namespaces
        rdf->seen_namespaces_ = parser.getSeenNamespaces();

        // Compare against predefined set of namespaces: bqbiol etc.
        // This allows us to only use the ones that are needed
        rdf->namespaces_ = rdf->propagateNamespacesFromParser(rdf->seen_namespaces_);
    }

    void RDF::addFromString(const std::string &str,
                            const std::string &format, const std::string &base_uri) {
        std::string base_uri_used;

        LibrdfParser parser(format);

        LibrdfUri u = LibrdfUri::fromFilename(base_uri_used);
        parser.parseString(str, model_, u);
        u.freeUri();

        // update the list of "seen" namespaces
        seen_namespaces_ = parser.getSeenNamespaces();

        // Compare against predefined set of namespaces: bqbiol etc.
        // This allows us to only use the ones that are needed
        namespaces_ = propagateNamespacesFromParser(seen_namespaces_);

    }

    /*
     * @brief parse RDF directly from a uri
     * @param uri_string the uri to download containing RDF
     * @param format the format that the RDF is in
     * @return RDF an instantiated RDF object.
     *
     * @details downloads uri from the internet and creates an RDF graph.
     * See Librdf::parseUri() for more details.
     */
    RDF RDF::fromUri(const std::string &uri_string, const std::string &format) {
        RDF rdf;
        LibrdfParser parser(format);
        parser.parseUri(uri_string, rdf.model_);
        return rdf;
    }

    /*
     * @brief non-static counterpart of RDF::fromUri. Downloads and
     * parses rdf from a URI.
     *
     * @details See RDF::fromUri for details.
     */
    void RDF::addFromUri(const std::string &uri_string, const std::string &format) {
        LibrdfParser parser(format);
        parser.parseUri(uri_string, model_);
    }

    RDF RDF::fromFile(const std::string &filename, const std::string &format) {
        RDF rdf;
        LibrdfParser parser(format);
        parser.parseFile(filename, rdf.model_);
        return rdf;
    }

    void RDF::addFromFile(const std::string &filename, const std::string &format) {
        LibrdfParser parser(format);
        parser.parseFile(filename, model_);
    }

    /*
     * @brief compared namespaces seen with namespaces
     * known and ensures models that use a known namespace
     * use that namespace.
     * @param seen_namespaces a vector of strings of namespaces the parser has seen before.
     *
     */
    std::unordered_map<std::string, std::string>
    RDF::propagateNamespacesFromParser(const std::vector<std::string> &seen_namespaces) {
        std::unordered_map<std::string, std::string> keep_map;
        for (auto &seen_namespace : seen_namespaces) {
            auto iter = default_namespaces_.find(seen_namespace);
            if (iter != default_namespaces_.end()) {
                keep_map[seen_namespace] = default_namespaces_[seen_namespace];
            }
        }
        return keep_map;
    }

//    std::string RDF::toString(const std::string &format, std::string base_uri,
//                              const char *mime_type, const char *type_uri) {
//        base_uri = OmexMetaUtils::prepareBaseUri(base_uri);
//        LibrdfSerializer serializer(format.c_str(), mime_type, type_uri);
//        // remember to add namespaces taken from parser
//        for (auto &it: namespaces_) {
//            serializer.setNamespace(it.first, it.second);
//        }
//        return serializer.toString(base_uri, model_);
//    }


    std::string
    RDF::toString(const std::string &format, const std::string &omex_name, const std::string &model_name,
                  std::string base_uri, const char *mime_type,
                  const char *type_uri) {
        base_uri = OmexMetaUtils::prepareBaseUri(base_uri);
        LibrdfSerializer serializer(format.c_str(), mime_type, type_uri);
        // remember to add namespaces taken from parser
        for (auto &it: namespaces_) {
            serializer.setNamespace(it.first, it.second);
        }
        std::vector<std::string> vec = OmexMetaUtils::configureSelfStrings(omex_name, model_name);
        serializer.setNamespace(vec[0], "myOMEXlib");
        serializer.setNamespace(vec[1], "myOMEX");
        serializer.setNamespace(vec[2], "local");
        return serializer.toString(base_uri, model_);
    }


    librdf_model *RDF::getModel() const {
        return model_.get();
    }

    Editor RDF::toEditor(const std::string &xml, SemsimXmlType type) {
        return Editor(xml, type, false, model_, namespaces_);
    }

    Editor *RDF::toEditorPtr(const std::string &xml, SemsimXmlType type) {
        auto *editor = new Editor(xml, type, false, model_, namespaces_);
        return editor;
    }

    librdf_storage *RDF::getStorage() const {
        return storage_.get();
    }


    int RDF::commitTransaction() const {
        return librdf_model_transaction_commit(getModel());
    }

    int RDF::startTransaction() const {
        return librdf_model_transaction_start(getModel());
    }

    void *RDF::getTransactionHandle() const {
        return librdf_model_transaction_get_handle(getModel());
    }

    int RDF::startTransactionWithHandle(void *handle) const {
        return librdf_model_transaction_start_with_handle(getModel(), handle);
    }

    int RDF::getTransactionRollback() const {
        return librdf_model_transaction_rollback(getModel());
    }

    std::ostringstream RDF::listOptions() {
        raptor_world *raptor_world_ptr = World::getRaptor();
        int num_raptor_options = (int) raptor_option_get_count() - 1;
        std::ostringstream os;
        os << "option, name, label, domain, value type, uri" << std::endl;
        int i = 0;
        while (i != num_raptor_options) {
            raptor_option_description *parser_opt = raptor_world_get_option_description(
                    raptor_world_ptr,
                    RAPTOR_DOMAIN_PARSER,
                    (raptor_option) i
            );
            if (parser_opt) {
                os << parser_opt->option << "," << parser_opt->name << "," << parser_opt->label << ","
                   << parser_opt->domain
                   << "," << parser_opt->value_type << "," << raptor_uri_to_string(parser_opt->uri) << std::endl;
            } else {
                raptor_option_description *serializer_opt = raptor_world_get_option_description(
                        raptor_world_ptr,

                        RAPTOR_DOMAIN_SERIALIZER,
                        (raptor_option) i
                );
                if (serializer_opt) {
                    os << serializer_opt->option << "," << serializer_opt->name << "," << serializer_opt->label
                       << ","
                       << serializer_opt->domain
                       << "," << serializer_opt->value_type << "," << raptor_uri_to_string(serializer_opt->uri)
                       << std::endl;
                }
            }
            i++;
        };
        return os;
    }

    const std::string &RDF::getRepositoryName() const {
        return repository_name_;
    }

    void RDF::setRepositoryName(std::string repositoryName) {
        if (!OmexMetaUtils::startsWith(repositoryName, "http")) {
            throw std::invalid_argument("std::invalid_argument: RDF::setRepositoryName: "
                                        "Specified \"repositoryName\" argument \"" + repositoryName
                                        + "\" does not begin with \"http\". Example: \"http://MyOmexRepository.org\"");
        }
        if (!OmexMetaUtils::endsWith(repositoryName, "/")) {
            repositoryName += "/";
        }
        repository_name_ = repositoryName;
    }

    const std::string &RDF::getArchiveName() const {
        return archive_name_;
    }

    void RDF::setArchiveName(std::string archiveName) {
        if (OmexMetaUtils::startsWith(archiveName, "http")) {
            throw std::invalid_argument("std::invalid_argument: RDF::setArchiveName: "
                                        "Specified \"archiveName\" argument \"" + archiveName
                                        + "\" begins with \"http\". Since the archive url is built "
                                          "using the repositoryName argument, please only specify "
                                          "the name of the omex archive. Like \"myOmexFile.omex\"");
        }
        if (!OmexMetaUtils::endsWith(archiveName, ".omex")) {
            archiveName = archiveName + ".omex";
        }
        archive_name_ = getRepositoryName() + archiveName;
    }

    const std::string &RDF::getModelName() const {
        return model_name_;
    }

    void RDF::setModelName(std::string modelName) {
        if (OmexMetaUtils::startsWith(modelName, "http")) {
            throw std::invalid_argument("std::invalid_argument: RDF::setModelName: "
                                        "Specified \"modelName\" argument \"" + modelName
                                        + "\" begins with \"http\". Since the model url is built "
                                          "using the repositoryName argument, please only specify "
                                          "the name of the model. Like \"MyModel.sbml\"");
        }
        std::vector<std::string> suffexes = {".xml", ".sbml", ".cellml"};
        bool good = false;
        for (auto &it : suffexes) {
            if (OmexMetaUtils::endsWith(modelName, it)) {
                good = true;
            }
        }
        // automaticall add .xml if one of the above suffixes was not detected
        if (!good) {
            modelName += ".xml";
        }

        if (OmexMetaUtils::endsWith(modelName, "/")) {
            model_name_ = getArchiveName() + "/" + modelName;
        } else {
            model_name_ = getArchiveName() + modelName;
        }

        // Since the model name is also used for the local name we
        // figure that out here. We know modelName definitely contains
        // a suffux like .xml.
        // we need to remove it so we can add .rdf.
        // We do this in a way that enables multiple "." in a model_name
        std::vector<std::string> split = OmexMetaUtils::splitStringBy(modelName, '.');
        if (split.size() <= 1) {
            throw std::logic_error("std::logic_error: RDF::setModelName: You should never get a "
                                   "a value less than 2 here because you are splitting a string. "
                                   "If you are seeing this message this is a bug. Please report "
                                   "it as a github issue (https://github.com/sys-bio/libOmexMeta/issues)");
        }
        // remove the last element which should contain the extension.
        split.pop_back();

        // build up the string again with any dots that appeared before the final
        std::ostringstream os;
        for (auto &it : split) {
            os << it << ".";
        }
        // Now we can build up the local string
        local_name_ = getArchiveName() + "/" + os.str() + "rdf#";
    }


}
