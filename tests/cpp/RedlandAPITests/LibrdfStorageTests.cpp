//
// Created by Ciaran on 5/17/2020.
//
#include "gtest/gtest.h"
#include "semsim/RedlandAPIWrapper/LibrdfWorld.h"
#include "semsim/RedlandAPIWrapper/LibrdfStorage.h"
#include "iostream"

class LibrdfStorageTests : public ::testing::Test {

public:

    LibrdfStorageTests() = default;

    int function_that_takes_a_storage(semsim::LibrdfWorld world_, semsim::LibrdfStorage storage) {
        librdf_model *m = librdf_new_model(world_.get(), storage.get(), nullptr);
        librdf_free_model(m);
        return 0;
    }

};

TEST_F(LibrdfStorageTests, TestInstantiateStorage) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    ASSERT_NE(storage1.get(), nullptr);
}

TEST_F(LibrdfStorageTests, TestCopyConstructor) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    semsim::LibrdfStorage storage2 = storage1;
    ASSERT_EQ(storage1, storage2);
}

TEST_F(LibrdfStorageTests, TestCopyAssignment) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    semsim::LibrdfStorage storage2 = world.newStorage("memory", "semsim_store2");
    storage2 = storage1;
    ASSERT_EQ(storage1, storage2);
}


TEST_F(LibrdfStorageTests, TestMoveConstructor) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    auto storage1_int_ptr = reinterpret_cast<std::uintptr_t>(storage1.get());
    semsim::LibrdfStorage storage2 = std::move(storage1);
    auto storage2_int_ptr = reinterpret_cast<std::uintptr_t>(storage2.get());
    ASSERT_EQ(storage1.getStorage(), nullptr);
    ASSERT_EQ(storage1_int_ptr, storage2_int_ptr);
}

TEST_F(LibrdfStorageTests, TestMoveAssignment) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    auto storage1_int_ptr = reinterpret_cast<std::uintptr_t>(storage1.get());
    semsim::LibrdfStorage storage2 = world.newStorage("memory", "semsim_store2");
    auto storage2_int_ptr = reinterpret_cast<std::uintptr_t>(storage2.get());
    storage1 = std::move(storage2);
    ASSERT_NE(storage1_int_ptr, storage2_int_ptr);
    ASSERT_EQ(storage2.getStorage(), nullptr);
}

TEST_F(LibrdfStorageTests, TestStorageInAFunctionAsArgument) {
    semsim::LibrdfWorld world;
    semsim::LibrdfStorage storage1 = world.newStorage("memory", "semsim_store1");
    int actual = function_that_takes_a_storage(world, storage1);
    int expected = 0;
    ASSERT_EQ(actual, expected);
}















