package com.lu.atromoby.interview_demo.interfaces;

import com.lu.atromoby.interview_demo.tools.CollectionView;
import com.lu.atromoby.interview_demo.tools.ItemHolder;

public interface Provider {
    ItemHolder getHolder(CollectionView v);
}
