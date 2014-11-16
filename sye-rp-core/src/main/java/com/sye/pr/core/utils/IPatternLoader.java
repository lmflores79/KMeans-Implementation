package com.sye.pr.core.utils;

import java.util.List;
import java.util.Set;

import com.sye.pr.core.model.IPattern;

public interface IPatternLoader {

	public Set<IPattern> loadPatterns(String fileName);
}
