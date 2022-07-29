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

@Component
class MyBaz {
	private val _hasError = MyBoolean(false)
	val hasError: Boolean get() = _hasError.get()

	fun whatever() {
	}
}

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	lateinit var foo: MyFoo

	@Autowired
	lateinit var bar: MyBar

	@Autowired
	lateinit var baz: MyBar

	@Test
	fun `foo fails`() {
		foo.hasError
	}

	@Test
	fun `bar works`() {
		bar.hasError
	}

	@Test
	fun `baz works`() {
		baz.hasError
	}
}
