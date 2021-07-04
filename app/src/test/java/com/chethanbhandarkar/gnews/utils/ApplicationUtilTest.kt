package com.chethanbhandarkar.gnews.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ApplicationUtilTest{

    @Test
	fun  `check Date util function`() {
		val dateToBeFormatted="2021-07-04T03:17:00+00:00"
		val actualResult=ApplicationUtil.convertDate(dateToBeFormatted)
		val expectedResult="04 Jul 2021   03:17"

		assertThat(actualResult).isEqualTo(expectedResult)

	}

}