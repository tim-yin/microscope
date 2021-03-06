package com.vipshop.microscope.collector.disruptor;

import com.lmax.disruptor.EventHandler;
import com.vipshop.microscope.collector.analyzer.MessageAnalyzer;

/**
 * Metric analyze handler.
 *
 * @author Xu Fei
 * @version 1.0
 */
public class MetricAnalyzeHandler implements EventHandler<MetricEvent> {

    private final MessageAnalyzer messageAnalyzer = MessageAnalyzer.getMessageAnalyzer();

    @Override
    public void onEvent(MetricEvent event, long sequence, boolean endOfBatch) throws Exception {
        messageAnalyzer.analyze(event.getResult());
    }
}