package org.example


/*---------------------------------------------------------------
 1. Encrypt a string using Caesar cipher shift
----------------------------------------------------------------*/
fun encryptString(input: String, key: Int): String {
    val normalizedKey = key % 26   // Ensure key stays within alphabet size
    val result = StringBuilder()

    for (char in input) {
        if (char.isLetter()) {
            val base = if (char.isLowerCase()) 'a' else 'A'
            // Shift the character and wrap around using modulo
            val shifted = ((char - base + normalizedKey + 26) % 26) + base.code
            result.append(shifted.toChar())
        } else {
            // Keep spaces and punctuation unchanged
            result.append(char)
        }
    }

    return result.toString()
}

/*---------------------------------------------------------------
 2. Check if two words are anagrams of each other
   (Sort the letters in both words and compare)
----------------------------------------------------------------*/
fun areAnagrams(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    // Convert to lowercase, sort characters, compare results
    return word1.lowercase().toCharArray().sorted() ==
            word2.lowercase().toCharArray().sorted()
}

/*---------------------------------------------------------------
 3. Check if string B is a substring of string A
    WITHOUT using String.contains()
    (Manual sliding window algorithm)
----------------------------------------------------------------*/
fun isSubstring(main: String, search: String): Boolean {
    if (search.isEmpty()) return true
    if (search.length > main.length) return false

    // Slide the "window" across the main string
    for (i in 0..(main.length - search.length)) {
        var match = true

        // Compare each character manually
        for (j in search.indices) {
            if (main[i + j] != search[j]) {
                match = false
                break
            }
        }

        if (match) return true
    }

    return false
}

/*---------------------------------------------------------------
 4. Find and return the longest word in a string
   (Split by spaces, track longest word)
----------------------------------------------------------------*/
fun longestWord(sentence: String): String {
    val words = sentence.split(" ")

    var longest = ""
    for (word in words) {
        if (word.length > longest.length) {
            longest = word
        }
    }
    return longest
}