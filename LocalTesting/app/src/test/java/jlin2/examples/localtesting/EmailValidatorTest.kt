package jlin2.examples.localtesting

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun validEmail_basicFormat_returnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun validEmail_subdomainFormat_returnsTrue() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }
}