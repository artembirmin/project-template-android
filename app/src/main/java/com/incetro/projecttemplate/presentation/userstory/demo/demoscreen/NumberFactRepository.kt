/*
 * ProjectTemplate
 *
 * Created by artembirmin on 11/8/2023.
 */

package com.incetro.projecttemplate.presentation.userstory.demo.demoscreen

import com.incetro.projecttemplate.entity.number.NumberFactResponse

interface NumberFactRepository {
    suspend fun getNumberFact(number: Int): NumberFactResponse
}