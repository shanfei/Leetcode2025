package com.meta.string;

/**
 *
 * Given an integer array data representing the data,
 * return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For a 1-byte character, the first bit is a 0, followed by its Unicode code.
 * For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0,
 * followed by n - 1 bytes with the most significant 2 bits being 10.
 *
 * This is how the UTF-8 encoding would work:
 *
 *      Number of Bytes   |        UTF-8 Octet Sequence
 *                        |              (binary)
 *    --------------------+-----------------------------------------
 *             1          |   0xxxxxxx
 *             2          |   110xxxxx 10xxxxxx
 *             3          |   1110xxxx 10xxxxxx 10xxxxxx
 *             4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * x denotes a bit in the binary form of a byte that may be either 0 or 1.
 *
 * Note: The input is an array of integers.
 * Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 *
 * Example 1:
 *
 * Input: data = [197,130,1]
 * Output: true
 * Explanation: data represents the octet sequence: 11000101 10000010 00000001.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 *
 * Example 2:
 *
 * Input: data = [235,140,4]
 * Output: false
 *
 * Explanation: data represented the octet sequence: 11101011 10001100 00000100.
 *
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 *
 *
 */
public class UTF8Validation {

    public boolean validUtf8(int[] data) {

        int index = 0;

        while ( index < data.length ) {

            int i = data[index];

            int countOfByte = getTotalCountOfAUTFStr(i);
            System.out.println(countOfByte);

            if ( countOfByte == -1 ) {
                return false;
            }

            while ( --countOfByte > 0 ) {
                index++;

                if ( index == data.length ) {
                    return false;
                }

                i = data[index];

                if ( !isFollowStandard(i) ) {
                    return false;
                }
            }

            index++;
        }

        return true;
    }

    public boolean isFollowStandard(int n) {
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        return ( ( mask1 & n ) == mask1 ) && (( mask2 & n ) == 0 ) ;
    }


    public int getTotalCountOfAUTFStr(int n) {
        int mask = 1 << 7; // 10000000
        int maxCount = 4;

        int count = 0;

        while ( ( mask & n ) != 0 ) {
            count++;
            mask >>= 1;
        }

        if (count == 0) {
            return 1;
        }

        if (count > maxCount || count == 1) {
            return -1;
        }

        return count;
    }


    public static void main(String[] args) {
        UTF8Validation u = new UTF8Validation();

   //     System.out.println(u.validUtf8(new int[]{197,194,1}));
    //    System.out.println(u.validUtf8(new int[]{235,140,4}));
  //      System.out.println(u.validUtf8(new int[]{197,130,1}));

//        System.out.println(u.getTotalCountOfAUTFStr(235));

       System.out.println( u.isFollowStandard(194) );
    }

}
