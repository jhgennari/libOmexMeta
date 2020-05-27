//
// Created by Ciaran on 5/17/2020.
//
#include "gtest/gtest.h"
#include "semsim/RedlandAPIWrapper/World.h"
#include "semsim/RedlandAPIWrapper/LibrdfParser.h"
#include "iostream"
#include "../AnnotationSamples.h"

using namespace semsim;

class LibrdfParserTests : public ::testing::Test {

public:

    AnnotationSamples samples;

    LibrdfParserTests() = default;

};

TEST_F(LibrdfParserTests, TestInstantiateParser) {
    LibrdfParser parser1 = LibrdfParser("rdfxml");
    ASSERT_NE(parser1.get(), nullptr);
}


TEST_F(LibrdfParserTests, TestMoveConstructor) {
    LibrdfParser parser1 = LibrdfParser("rdfxml");
    auto parser1_int_ptr = reinterpret_cast<std::uintptr_t>(parser1.get());
    LibrdfParser parser2 = std::move(parser1);
    auto parser2_int_ptr = reinterpret_cast<std::uintptr_t>(parser2.get());
    ASSERT_EQ(parser1.get(), nullptr);
    ASSERT_EQ(parser1_int_ptr, parser2_int_ptr);
}

TEST_F(LibrdfParserTests, TestMoveAssignment) {
    LibrdfParser parser1 = LibrdfParser("rdfxml");
    auto parser1_int_ptr = reinterpret_cast<std::uintptr_t>(parser1.get());
    LibrdfParser parser2 = LibrdfParser("rdfxml");
    auto parser2_int_ptr = reinterpret_cast<std::uintptr_t>(parser2.get());
    parser1 = std::move(parser2);
    ASSERT_NE(parser1_int_ptr, parser2_int_ptr);
    ASSERT_EQ(parser2.get(), nullptr);
}

TEST_F(LibrdfParserTests, TestParseSomething) {
    LibrdfStorage storage;
    LibrdfModel model(storage);
    LibrdfParser parser1 = LibrdfParser("rdfxml");
    LibrdfUri base("./base");
    parser1.parseString(samples.singular_annotation1, model, base);
    const LibrdfUri &u = parser1.getNamespacesSeenUri(0);

}















