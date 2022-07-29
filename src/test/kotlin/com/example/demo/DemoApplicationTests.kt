package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

class MyBoolean(var value: Boolean) {
	fun get(): Boolean = value
}

abstract class Foo {
	private val _hasError = MyBoolean(false)
	val hasError: Boolean get() = _hasError.get()
}

@Component
class MyFoo : Foo() {
	@Transactional
	fun whatever() {
	}
}

@Component
class MyBar : Foo() {
	fun whatever() {
	}
}

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	lateinit var foo: MyFoo

	@Autowired
	lateinit var bar: MyBar

	@Test
	fun fooWorks() {
		foo.hasError
	}

	@Test
	fun barWorks() {
		bar.hasError
	}
}
