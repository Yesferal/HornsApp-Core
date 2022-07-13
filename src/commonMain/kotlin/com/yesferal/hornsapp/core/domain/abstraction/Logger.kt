/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

/**
 * This class is a Logger abstraction
 * is part of a Chain Of Responsibility pattern
 * and it should be implemented in the App UI Module
 *
 * @author Yesferal
 */
interface Logger {
    fun d(message: String)
    fun e(message: String)
}
