package org.empleodigital.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshFilter extends ConfigurableSiteMeshFilter {

	@Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/decorators/tags.jsp").addExcludedPath("/excluded/*")
                .addExcludedPath("/resources/*").addExcludedPath("/decorators/*");
    }
	
}
