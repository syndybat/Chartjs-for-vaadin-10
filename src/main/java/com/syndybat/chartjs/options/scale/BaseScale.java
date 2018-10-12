package com.syndybat.chartjs.options.scale;


import com.syndybat.chartjs.options.Position;
import com.syndybat.chartjs.utils.JUtils;
import com.syndybat.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

/**
 * @author michael@byteowls.com
 */
public abstract class BaseScale<B extends BaseScale<?>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -2382244938070735956L;

    private String id;
    protected String type;
    protected Boolean display;
    protected Position position;
    protected Boolean stacked;
    protected Integer barThickness;
    protected Integer maxBarThickness;
    protected Double categoryPercentage;
    protected Double barPercentage;
    protected GridLines<B> gridLines;
    protected Ticks<B> ticks;
    protected ScaleLabel<B> scaleLabel;

    /**
     * "category", "linear", "logarithmic", "time", "radialLinear"
     */
    public BaseScale<B> type(String type) {
        this.type = type;
        return this;
    }

    /**
     * If true, show the scale including gridlines, ticks, and labels. Overrides gridLines.display, scaleLabel.display, and ticks.display.
     */
    public BaseScale<B> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * The ID is used to link datasets and scale axes together. The properties `datasets.xAxisID` or `datasets.yAxisID` have to match the scale properties `scales.xAxes.id` or `scales.yAxes.id`. This is especially needed if multi-axes charts are used.
     */
    public BaseScale<B> id(String id) {
        this.id = id;
        return this;
    }

    /**
     * If true, bars are stacked on the x-axis
     */
    public BaseScale<B> stacked(boolean stacked) {
        this.stacked = stacked;
        return this;
    }

    /**
     * Manually set width of each bar in pixels. If not set, the bars are sized automatically.
     */
    public BaseScale<B> barThickness(int barThickness) {
        this.barThickness = barThickness;
        return this;
    }

    /**
     * Set this to ensure that the automatically sized bars are not sized thicker than this. Only works if barThickness is not set (automatic sizing is enabled).
     */
    public BaseScale<B> maxBarThickness(int maxBarThickness) {
        this.maxBarThickness = maxBarThickness;
        return this;
    }

    /**
     * Percent (0-1) of the available width (the space between the gridlines for small datasets) for each data-point to use for the bars.
     */
    public BaseScale<B> categoryPercentage(double categoryPercentage) {
        this.categoryPercentage = categoryPercentage;
        return this;
    }

    /**
     * Percent (0-1) of the available width each bar should be within the category percentage. 1.0 will take the whole category width and put the bars right next to each other.
     */
    public BaseScale<B> barPercentage(double barPercentage) {
        this.barPercentage = barPercentage;
        return this;
    }


    /**
     * Position of the scale.
     */
    public BaseScale<B> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * It defines options for the grid lines that run perpendicular to the axis.
     */
    public GridLines<B> gridLines() {
        if (gridLines == null) {
            gridLines = new GridLines<>(getThis());
        }
        return gridLines;
    }

    /**
     * Define options for the scale title.
     */
    public ScaleLabel<B> scaleLabel() {
        if (scaleLabel == null) {
            scaleLabel = new ScaleLabel<>(getThis());
        }
        return scaleLabel;
    }

    /**
     * It defines options for the tick marks that are generated by the axis.
     */
    public Ticks<B> ticks() {
        if (ticks == null) {
            ticks = new Ticks<>(getThis());
        }
        return ticks;
    }

    public abstract B getThis();


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNull(map, "id", id);
        JUtils.putNotNull(map, "stacked", stacked);
        JUtils.putNotNull(map, "barThickness", barThickness);
        JUtils.putNotNull(map, "maxBarThickness", maxBarThickness);
        JUtils.putNotNull(map, "categoryPercentage", categoryPercentage);
        JUtils.putNotNull(map, "barPercentage", barPercentage);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "gridLines", gridLines);
        JUtils.putNotNull(map, "scaleLabel", scaleLabel);
        JUtils.putNotNull(map, "ticks", ticks);
        return map;
    }
}
