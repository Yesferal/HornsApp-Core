/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core

import org.junit.After
import org.junit.Before
import org.mockito.MockitoAnnotations

/**
 * Interface to define a contract to Mockito library
 *
 * @author Yesferal
 */
interface MockitoTest {

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)
    }

    @Before
    fun mockClasses() {
    }

    @After
    fun close() {
    }
}
