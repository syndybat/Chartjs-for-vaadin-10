package com.syndybat.chartjs.options.scale;

import com.syndybat.chartjs.utils.JUtils;
import elemental.json.JsonObject;

/**
 * The category scale will be familiar to those who have used v1.0.
 * Labels are drawn in from the labels array included in the chart data.
 *
 * @author michael@byteowls.com
 */
public class CategoryScale extends BaseScale<CategoryScale> {

    private static final long serialVersionUID = 5698788408274123785L;

    private CategoryTicks<CategoryScale> categoryTicks;

    public CategoryScale() {
        type("category");
    }

    /**
     * It defines options for the tick marks that are generated by the axis.
     */
    @Override
    public CategoryTicks<CategoryScale> ticks() {
        if (this.categoryTicks == null) {
            this.categoryTicks = new CategoryTicks<>(getThis());
        }
        return this.categoryTicks;
    }

    @Override
    public CategoryScale getThis() {
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "ticks", categoryTicks);
        return map;
    }
}
