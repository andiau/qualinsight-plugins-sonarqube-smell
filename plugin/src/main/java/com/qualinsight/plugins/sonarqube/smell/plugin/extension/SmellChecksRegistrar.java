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
package com.qualinsight.plugins.sonarqube.smell.plugin.extension;

import java.util.List;
import com.google.common.collect.Lists;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import com.qualinsight.plugins.sonarqube.smell.api.annotation.Smell;
import com.qualinsight.plugins.sonarqube.smell.plugin.check.SmellCheck;

/**
 * Code Smells plugin {@link CheckRegistrar} that registers all Smell related checks. Current implementation registers the {@link Smell} annotation detection check for both source and test classes.
 *
 * @author Michel Pawlak
 */
public final class SmellChecksRegistrar implements CheckRegistrar {

    private static final List<Class<? extends JavaCheck>> checkClasses;

    private static final List<Class<? extends JavaCheck>> testCheckClasses;

    /*
     * Block that builds the list of JavaCheck once and for all.
     */
    static {
        checkClasses = Lists.<Class<? extends JavaCheck>> newArrayList();
        checkClasses.add(SmellCheck.class);
        testCheckClasses = Lists.<Class<? extends JavaCheck>> newArrayList();
        testCheckClasses.add(SmellCheck.class);
    }

    @Override
    public void register(final RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(SmellRulesDefinition.REPOSITORY_KEY, checkClasses(), testCheckClasses());
    }

    /**
     * Returns all {@link JavaCheck} that need to be applied to source code.
     *
     * @return checks to be applied to source code
     */
    public static Iterable<Class<? extends JavaCheck>> checkClasses() {
        return checkClasses;
    }

    /**
     * Returns all {@link JavaCheck} that need to be applied to test code.
     *
     * @return checks to be applied to test code
     */
    public static Iterable<Class<? extends JavaCheck>> testCheckClasses() {
        return testCheckClasses;
    }

}
