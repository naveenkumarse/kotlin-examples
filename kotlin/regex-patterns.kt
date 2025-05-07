fun main() {
    matchExactText()
    matchAnyCharacter()
    matchCharacterSet()
    matchRepetition()
    matchStartEnd()
    matchDigitsWords()
    useRegexFunctions()
    extractMatches()
    splitExample()
    findAllExample()
}

fun matchExactText() {
    val text = "hello world"
    val regex = Regex("hello")
    println("Exact match: ${regex.containsMatchIn(text)}") // true
}

fun matchAnyCharacter() {
    val regex = Regex("h.llo")
    println("Any character match:")
    println(regex.matches("hello"))  // true
    println(regex.matches("hallo"))  // true
    println(regex.matches("hxllo"))  // true
}

fun matchCharacterSet() {
    val regex = Regex("h[ae]llo")
    println("Character set match:")
    println(regex.matches("hello"))  // true
    println(regex.matches("hallo"))  // true
    println(regex.matches("hullo"))  // false
}

fun matchRepetition() {
    val regex = Regex("go*gle")
    println("Repetition match:")
    println(regex.matches("gogle"))    // true
    println(regex.matches("google"))   // true
    println(regex.matches("gooogle"))  // true
    println(regex.matches("ggle"))     // false
}

fun matchStartEnd() {
    val regex = Regex("^hello$")
    println("Start and end match:")
    println(regex.matches("hello"))        // true
    println(regex.matches("hello world"))  // false
}

fun matchDigitsWords() {
    val digitRegex = Regex("\\d{3}")
    val wordRegex = Regex("\\w+")
    println("Digit match:")
    println(digitRegex.matches("123"))  // true
    println(digitRegex.matches("12a"))  // false
    println("Word match:")
    println(wordRegex.matches("word_1")) // true
}

fun useRegexFunctions() {
    val text = "The cat sat on the mat."
    val regex = Regex("cat")
    println("Contains 'cat': ${regex.containsMatchIn(text)}") // true
}

fun extractMatches() {
    val text = "Email me at abc@example.com or xyz@example.com"
    val regex = Regex("[\\w.]+@[\\w.]+")
    println("Extracted emails:")
    regex.findAll(text).forEach {
        println(it.value)
    }
}

fun splitExample() {
    val text = "one, two;three four"
    val regex = Regex("[,; ]+")
    val parts = regex.split(text)
    println("Split result:")
    parts.forEach { println(it) }
}

fun findAllExample() {
    val text = "Order numbers: A123, B456, C789"
    val regex = Regex("[A-Z]\\d+")
    println("Find all order codes:")
    regex.findAll(text).forEach {
        println(it.value)
    }
}
