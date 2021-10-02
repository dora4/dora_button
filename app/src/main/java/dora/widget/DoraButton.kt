package dora.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton

class DoraButton : AppCompatButton {

    var cornerRadius: Float = 0f
    var disableBgColor: Int = Color.LTGRAY
    var disableTextColor: Int = Color.WHITE
    var normalBgColor: Int = Color.BLACK
    var normalTextColor: Int = Color.WHITE
    var hoverBgColor: Int = Color.BLACK
    var hoverTextColor: Int = Color.WHITE

    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DoraButton, defStyleAttr, 0)
        cornerRadius = a.getDimension(R.styleable.DoraButton_dora_cornerRadius, cornerRadius)
        disableBgColor = a.getColor(R.styleable.DoraButton_dora_disableBgColor, disableBgColor)
        disableTextColor = a.getColor(R.styleable.DoraButton_dora_disableTextColor, disableTextColor)
        normalBgColor = a.getColor(R.styleable.DoraButton_dora_normalBgColor, normalBgColor)
        normalTextColor = a.getColor(R.styleable.DoraButton_dora_normalTextColor, normalTextColor)
        hoverBgColor = a.getColor(R.styleable.DoraButton_dora_hoverBgColor, hoverBgColor)
        hoverTextColor = a.getColor(R.styleable.DoraButton_dora_hoverTextColor, hoverTextColor)
        a.recycle()
        val textColors = ColorStateList(
                arrayOf(intArrayOf(-android.R.attr.state_enabled),intArrayOf(android.R.attr.state_pressed),IntArray(0)),
                intArrayOf(disableTextColor, hoverTextColor, normalTextColor)
        )
        setTextColor(textColors)
        gravity = Gravity.CENTER
        setBackgroundDrawable(background)
        // 让没有设置listener时有颜色变化效果
        setOnClickListener {  }
    }

    override fun getBackground(): Drawable {
        val stateListDrawable = StateListDrawable()
        val disableDrawable = GradientDrawable()
        val hoverDrawable = GradientDrawable()
        val normalDrawable = GradientDrawable()
        disableDrawable.cornerRadius = cornerRadius
        hoverDrawable.cornerRadius = cornerRadius
        normalDrawable.cornerRadius = cornerRadius
        disableDrawable.setColor(disableBgColor)
        hoverDrawable.setColor(hoverBgColor)
        normalDrawable.setColor(normalBgColor)
        stateListDrawable.addState(intArrayOf(-android.R.attr.state_enabled), disableDrawable)
        stateListDrawable.addState(intArrayOf(android.R.attr.state_pressed), hoverDrawable)
        stateListDrawable.addState(IntArray(0), normalDrawable)
        return stateListDrawable
    }
}