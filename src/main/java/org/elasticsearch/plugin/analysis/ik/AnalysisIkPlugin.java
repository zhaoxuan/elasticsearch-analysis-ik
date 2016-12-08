package org.elasticsearch.plugin.analysis.ik;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.index.analysis.IkAnalysisBinderProcessor;
import org.elasticsearch.indices.analysis.IKIndicesAnalysisModule;
import org.elasticsearch.plugins.Plugin;

import java.util.Collection;
import java.util.Collections;


public class AnalysisIkPlugin extends Plugin {
	public static String PLUGIN_NAME = "analysis-ik";

    @Override public String name() {
        return PLUGIN_NAME;
    }


    @Override public String description() {
        return PLUGIN_NAME;
    }

    @Override
    public Collection<Module> nodeModules() {
        return Collections.<Module>singletonList(new IKIndicesAnalysisModule());
    }
    public void onModule(AnalysisModule module) {
        module.addProcessor(new IkAnalysisBinderProcessor());
    }

}
