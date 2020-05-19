//
// Created by Ciaran on 5/17/2020.
//

#include <string>
#include <utility>
#include <iostream>
#include "LibrdfModel.h"
#include "semsim/SemsimUtils.h"

namespace semsim {

    LibrdfModel::LibrdfModel(librdf_model *model, std::string options)
            : model_(std::make_shared<librdf_model *>(model)), options_(std::move(options)) {
    }

    LibrdfModel::~LibrdfModel() {
        if (model_.use_count() == 1) {
            librdf_free_model(*model_);
        }
    }

    LibrdfModel::LibrdfModel(const LibrdfModel &librdfModel) {
        // If we already have a model in this object, get rid
        // before we take librdfModel.model_ copy
        std::cout << model_ << std::endl;
        if (model_ != nullptr){
            librdf_free_model(*model_);
        }
        model_ = librdfModel.model_;
        options_ = librdfModel.options_;
    }

    LibrdfModel &LibrdfModel::operator=(const LibrdfModel &librdfModel) {
        if (this != &librdfModel) {
            librdf_free_model(*this->model_);
            model_ = librdfModel.model_;
            options_ = librdfModel.options_;
        }
        return *this;
    }

    LibrdfModel &LibrdfModel::operator=(LibrdfModel &&librdfModel) noexcept {
        if (this != &librdfModel) {
            std::cout << "move assignment" << std::endl;
            librdf_free_model(*this->model_); // free current model before taking theirs
            model_ = std::move(librdfModel.model_);
            options_ = std::move(librdfModel.options_);
        }
        return *this;
    }

    LibrdfModel::LibrdfModel(LibrdfModel &&librdfModel) noexcept {
        model_ = std::move(librdfModel.model_);
        options_ = std::move(librdfModel.options_);
    }


    bool LibrdfModel::operator==(const LibrdfModel &rhs) const {
        return model_ == rhs.model_;
    }

    bool LibrdfModel::operator!=(const LibrdfModel &rhs) const {
        return !(rhs == *this);
    }

    const std::string &LibrdfModel::getOptions() const {
        return options_;
    }

    const std::shared_ptr<librdf_model *> &LibrdfModel::getModel() const {
        return model_;
    }

}

