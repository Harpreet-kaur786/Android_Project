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

    @Test
    fun invalidEmail_missingDomain_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun invalidEmail_doubleDots_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun invalidEmail_noUsername_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun invalidEmail_noAtSymbol_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun invalidEmail_emptyString_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun invalidEmail_null_returnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}