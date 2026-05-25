/**
 * murmurhash - Pure Java implementation of the Murmur Hash algorithms.
 * Copyright (c) 2014, Sandeep Gupta
 *
 * http://sangupta.com/projects/murmur
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sangupta.murmur;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * A pure Java implementation of the Murmur 3 hashing algorithm as presented
 * at <a href="https://sites.google.com/site/murmurhash/">Murmur Project</a>
 *
 * Code is ported from original C++ source at
 * <a href="https://code.google.com/p/smhasher/source/browse/trunk/MurmurHash3.cpp">
 * MurmurHash3.cpp</a>
 *
 * @author sangupta
 * @since 1.0
 */
public class Murmur3 implements MurmurConstants {

    private static final int X86_32_C1 = 0xcc9e2d51;

    private static final int X86_32_C2 = 0x1b873593;

    private static long X64_128_C1 = 0x87c37b91114253d5L;

    private static long X64_128_C2 = 0x4cf5ad432745937fL;

    /**
     * Compute the Murmur3 hash as described in the original source code.
     *
     * @param data
     *            the data that needs to be hashed
     *
     * @param length
     *            the length of the data that needs to be hashed
     *
     * @param seed
     *            the seed to use to compute the hash
     *
     * @return the computed hash value
     */
    public static long hash_x86_32(final byte[] data, int length, long seed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compute the Murmur3 hash (128-bit version) as described in the original source code.
     *
     * @param data
     *            the data that needs to be hashed
     *
     * @param length
     *            the length of the data that needs to be hashed
     *
     * @param seed
     *            the seed to use to compute the hash
     *
     * @return the computed hash value
     */
    public static long[] hash_x64_128(final byte[] data, final int length, final long seed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static long mixK1(long k1) {
        k1 *= X64_128_C1;
        k1 = Long.rotateLeft(k1, 31);
        k1 *= X64_128_C2;
        return k1;
    }

    private static long mixK2(long k2) {
        k2 *= X64_128_C2;
        k2 = Long.rotateLeft(k2, 33);
        k2 *= X64_128_C1;
        return k2;
    }

    /**
     * Rotate left for 32 bits.
     *
     * @param original
     * @param shift
     * @return
     */
    private static long rotl32(long original, int shift) {
        return ((original << shift) & UINT_MASK) | ((original >>> (32 - shift)) & UINT_MASK);
    }

    /**
     * Rotate left for 64 bits.
     *
     * @param original
     * @param shift
     * @return
     */
    /**
     * fmix function for 32 bits.
     *
     * @param h
     * @return
     */
    private static long fmix32(long h) {
        h ^= (h >> 16) & UINT_MASK;
        h = (h * 0x85ebca6bl) & UINT_MASK;
        h ^= (h >> 13) & UINT_MASK;
        h = (h * 0xc2b2ae35) & UINT_MASK;
        h ^= (h >> 16) & UINT_MASK;
        return h;
    }

    /**
     * fmix function for 64 bits.
     *
     * @param k
     * @return
     */
    private static long fmix64(long k) {
        k ^= k >>> 33;
        k *= 0xff51afd7ed558ccdL;
        k ^= k >>> 33;
        k *= 0xc4ceb9fe1a85ec53L;
        k ^= k >>> 33;
        return k;
    }
}
