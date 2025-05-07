import kotlinx.coroutines.*

fun main() = runBlocking {
    println("=== 1. runBlocking + delay ===")
    runBlockingExample()

    println("\n=== 2. launch ===")
    launchExample()

    println("\n=== 3. async/await ===")
    asyncExample()

    println("\n=== 4. coroutineScope ===")
    coroutineScopeExample()

    println("\n=== 5. suspend function ===")
    suspendFunctionExample()

    println("\n=== 6. Dispatchers ===")
    dispatcherExample()
}

// 1. runBlocking + delay
suspend fun runBlockingExample() {
    println("Start")
    delay(1000) // non-blocking
    println("End after delay")
}

// 2. launch
suspend fun launchExample() = coroutineScope {
    launch {
        delay(500)
        println("Hello from launch")
    }
    println("Main continues immediately")
    delay(1000) // wait for launched coroutine to finish
}

// 3. async/await
suspend fun asyncExample() = coroutineScope {
    val deferred = async {
        delay(1000)
        42
    }
    println("Waiting for result...")
    val result = deferred.await()
    println("Result: $result")
}

// 4. coroutineScope
suspend fun coroutineScopeExample() = coroutineScope {
    launch {
        delay(300)
        println("First task done")
    }
    launch {
        delay(100)
        println("Second task done")
    }
    println("Waiting for tasks to finish...")
}

// 5. suspend function
suspend fun suspendFunctionExample() {
    val data = fetchData()
    println("Fetched: $data")
}

suspend fun fetchData(): String {
    delay(500)
    return "Hello Data"
}

// 6. Dispatchers
suspend fun dispatcherExample() = coroutineScope {
    launch(Dispatchers.Default) {
        println("Running on Default: ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) {
        println("Running on IO: ${Thread.currentThread().name}")
    }
}
