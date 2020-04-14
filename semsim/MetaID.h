//
// Created by Ciaran on 4/14/2020.
//

#ifndef LIBSEMGEN_METAID_H
#define LIBSEMGEN_METAID_H

#include <string>

namespace semsim {
    class MetaID {
    private:
        std::string base_;
        long number_;
        int num_digits_;

    public:
        MetaID(std::string base, long number, int num_digits = 4);

        bool operator==(const MetaID &rhs) const;

        bool operator!=(const MetaID &rhs) const;

        std::string generate() const;

        std::string generate(long n) const;

        int maxNumber() const;

        static int countDigits(long n);
    };
}

#endif //LIBSEMGEN_METAID_H
