package com.yesferal.hornsapp.core

import org.junit.Before
import org.mockito.MockitoAnnotations

interface MockitoTest {

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Before
    fun mockClasses() {}
}
