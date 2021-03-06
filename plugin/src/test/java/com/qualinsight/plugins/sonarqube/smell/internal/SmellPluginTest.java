/*
 * qualinsight-plugins-sonarqube-smell
 * Copyright (c) 2015, QualInsight
 * http://www.qualinsight.com/
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, you can retrieve a copy
 * from <http://www.gnu.org/licenses/>.
 */
package com.qualinsight.plugins.sonarqube.smell.internal;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import com.qualinsight.plugins.sonarqube.smell.plugin.SmellPlugin;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellChecksRegistrar;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellCountByTypeMeasuresComputer;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellCountTotalMeasureComputer;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellDebtComputer;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellMeasuresSensor;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellMetrics;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellRulesDefinition;
import com.qualinsight.plugins.sonarqube.smell.plugin.extension.SmellWidget;

public class SmellPluginTest {

    private static final int EXPECTED_EXTENSIONS_COUNT = 8;

    @SuppressWarnings("unchecked")
    @Test
    public void getExtensions_should_return_expectedExtensions() {
        final SmellPlugin sut = new SmellPlugin();
        @SuppressWarnings("rawtypes")
        final List actualExtensions = sut.getExtensions();
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualExtensions)
            .hasSize(EXPECTED_EXTENSIONS_COUNT);
        softly.assertThat(actualExtensions)
            .contains(SmellChecksRegistrar.class);
        softly.assertThat(actualExtensions)
            .contains(SmellMetrics.class);
        softly.assertThat(actualExtensions)
            .contains(SmellWidget.class);
        softly.assertThat(actualExtensions)
            .contains(SmellRulesDefinition.class);
        softly.assertThat(actualExtensions)
            .contains(SmellMeasuresSensor.class);
        softly.assertThat(actualExtensions)
            .contains(SmellDebtComputer.class);
        softly.assertThat(actualExtensions)
            .contains(SmellCountByTypeMeasuresComputer.class);
        softly.assertThat(actualExtensions)
            .contains(SmellCountTotalMeasureComputer.class);
        softly.assertAll();
    }

}
