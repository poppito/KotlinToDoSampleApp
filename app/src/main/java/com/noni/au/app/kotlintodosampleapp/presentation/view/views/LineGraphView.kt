package com.noni.au.app.kotlintodosampleapp.presentation.view.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.noni.au.app.kotlintodosampleapp.R


class LineGraphView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var lineStrokeColour = context.resources.getColor(android.R.color.black)
    private var bgColour = context.resources.getColor(android.R.color.white)
    private var strokeWidth = context.resources.getDimension(R.dimen.strokeWidth)

    private val TOP_OFFSET = 50f

    //stub data
    private val values = listOf(1.3f, 1.8f, 1.1f, 0.9f)
    private val textOffset = 15f

    var plotPaint: Paint
    var textPaint: Paint

    var graphContainer : LinearLayout

    init {
        setWillNotDraw(false)
        buildLayout(context, attrs)
        plotPaint = initialisePlotPaint()
        textPaint = initialiseTextPaint(context)
        graphContainer = buildGraphLayout(context)
        addView(graphContainer)
    }


    //region private

    private fun buildLayout(context: Context, attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(attrs,
                R.styleable.LineGraphView,
                0,
                0)

        if (typedArray != null) {
            bgColour = typedArray.getColor(R.styleable.LineGraphView_bgColour, bgColour)
            strokeWidth = typedArray.getDimension(R.styleable.LineGraphView_strokeWidth, strokeWidth)
        }
    }

    private fun buildGraphLayout(context: Context): LinearLayout {
        val graphContainer = LinearLayout(context)
        graphContainer.layoutParams  = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        return graphContainer
    }

    private fun initialisePlotPaint() : Paint {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = lineStrokeColour
        paint.strokeWidth = strokeWidth
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.SQUARE
        paint.strokeJoin = Paint.Join.BEVEL
        return paint
    }

    private fun initialiseTextPaint(context : Context) : Paint {
        val paint = Paint()
        paint.color = lineStrokeColour
        paint.textSize = context.resources.getDimension(R.dimen.textsize)
        return paint
    }

    private fun calculateXIncrements(layout: LinearLayout, values: Int) : Float {
        return layout.width.div(values + 1).toFloat()
    }

    private fun calculateYIncrements(layout: LinearLayout, max: Float) : Float {
        return (layout.height.toFloat() - TOP_OFFSET).div(max)
    }

    private fun calculateLines(layout: LinearLayout): List<Line> {
        var lines = emptyList<Line>()
        var currentX = 0f
        val xIncrement = calculateXIncrements(layout, values.count())
        val yIncrement = calculateYIncrements(layout, values.max()!!)
        var currentY = layout.bottom.toFloat()

        values.forEach {
            item ->
            var stopY = layout.bottom.toFloat() - (item * yIncrement)
            lines += Line(currentX, currentY, currentX+xIncrement, stopY, item)
            currentX += xIncrement
            currentY = stopY
        }

        return lines
    }


    //endregion

    //region lifecycle

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        calculateLines(graphContainer).forEach {
            //what order is this in?
            line ->
            canvas?.drawLine(line.startX, line.startY, line.stopX, line.stopY, plotPaint)
            canvas?.drawText(line.value.toString(), line.stopX + textOffset, line.stopY + textOffset, textPaint)
        }
    }


    class Line(var startX: Float, var startY: Float, var stopX: Float, var stopY: Float, var value: Float)
}