package com.example.memor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var listOchYop= arrayOf(false, false, false, false, false, false)
    var count=0
    var rasmId= arrayOfNulls<Int>(2)
    var imageIndex= arrayOfNulls<Int>(2)
    var animaDoing=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ishgaTushir()

        restart.setOnClickListener {

            yangila()
            ishgaTushir()

        }
    }
    fun ishgaTushir(){
        var tanla = Random().nextInt(8)
        when (tanla) {
            0 -> {xolat1()}
            1 -> {xolat2()}
            2 -> {xolat4()}
            3 -> {xolat2()}
            4 -> {xolat3()}
            5 -> {xolat1()}
            6 -> {xolat4()}
            7 -> {xolat3()}

        }

    }
    fun xolat1() {
        image_1.setOnClickListener {clickOn(image_1, R.drawable.jahon3, 0)}
        image_2.setOnClickListener {clickOn(image_2, R.drawable.jahon4, 1)}
        image_3.setOnClickListener {clickOn(image_3, R.drawable.jahon5, 2)}
        image_4.setOnClickListener {clickOn(image_4, R.drawable.jahon5, 3)}
        image_5.setOnClickListener {clickOn(image_5, R.drawable.jahon4, 4)}
        image_6.setOnClickListener {clickOn(image_6, R.drawable.jahon3, 5)}
    }
    fun xolat2() {
        image_1.setOnClickListener {clickOn(image_1, R.drawable.jahon5, 0)}
        image_2.setOnClickListener {clickOn(image_2, R.drawable.jahon4, 1)}
        image_3.setOnClickListener {clickOn(image_3, R.drawable.jahon3, 2)}
        image_4.setOnClickListener {clickOn(image_4, R.drawable.jahon4, 3)}
        image_5.setOnClickListener {clickOn(image_5, R.drawable.jahon3, 4)}
        image_6.setOnClickListener {clickOn(image_6, R.drawable.jahon5, 5)}
    }
    fun xolat3() {
        image_1.setOnClickListener {clickOn(image_1, R.drawable.jahon4, 0)}
        image_2.setOnClickListener {clickOn(image_2, R.drawable.jahon5, 1)}
        image_3.setOnClickListener {clickOn(image_3, R.drawable.jahon3, 2)}
        image_4.setOnClickListener {clickOn(image_4, R.drawable.jahon5, 3)}
        image_5.setOnClickListener {clickOn(image_5, R.drawable.jahon3, 4)}
        image_6.setOnClickListener {clickOn(image_6, R.drawable.jahon4, 5)}
    } fun xolat4() {
        image_1.setOnClickListener {clickOn(image_1, R.drawable.jahon5, 0)}
        image_2.setOnClickListener {clickOn(image_2, R.drawable.jahon3, 1)}
        image_3.setOnClickListener {clickOn(image_3, R.drawable.jahon3, 2)}
        image_4.setOnClickListener {clickOn(image_4, R.drawable.jahon4, 3)}
        image_5.setOnClickListener {clickOn(image_5, R.drawable.jahon5, 4)}
        image_6.setOnClickListener {clickOn(image_6, R.drawable.jahon4, 5)}
    }


    fun clickOn(imageView: ImageView, rasm: Int, index: Int) {
        if (animaDoing==false) {
            if (listOchYop[index] == false) {
                open(imageView, rasm, index)
            } else {
                close(imageView, rasm, index)
            }
        }


    }


    fun open(imageView: ImageView, rasm: Int, index: Int) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animaDoing=true
            }

            override fun onAnimationEnd(animation: Animation?) {
                var animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        listOchYop[index] = true
                        rasmId[count] = rasm
                        imageIndex[count] = index
                        count++
                        if (count == 2) {
                            if (rasmId[0] == rasmId[1]) {
                                rasmAniqla(imageIndex[0]!!).visibility = View.INVISIBLE
                                count--
                                rasmAniqla(imageIndex[1]!!).visibility = View.INVISIBLE
                                count--
                            } else {
                                close(rasmAniqla(imageIndex[0]!!), -1, imageIndex[0]!!)
                                close(rasmAniqla(imageIndex[1]!!), -1, imageIndex[1]!!)
                            }
                        }
                        animaDoing=false


                    }

                    override fun onAnimationRepeat(p0: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(animation: Animation?) {


            }
        })

    }


    fun close(imageView: ImageView, rasm: Int, index: Int) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim_2)
        imageView.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animaDoing=true
            }

            override fun onAnimationEnd(animation: Animation?) {
                var animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.jahon2)
                animation2.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationStart(p0: Animation?) {
                    }
                    override fun onAnimationEnd(p0: Animation?) {
                        animaDoing=false


                    }
                    override fun onAnimationRepeat(p0: Animation?) {
                    }
                })
            }
            override fun onAnimationRepeat(animation: Animation?) {

            }
        })
        listOchYop[index] = false
        count--
    }

    fun rasmAniqla(index: Int): ImageView {
        var imageView: ImageView? = null
        when (index) {
            0 -> {imageView = image_1 }
            1 -> {imageView = image_2 }
            2 -> {imageView = image_3 }
            3 -> {imageView = image_4 }
            4 -> {imageView = image_5 }
            5 -> {imageView = image_6 }
        }
        return imageView!!
    }
    fun yangila(){

        for (i in 0 until listOchYop.size){
            listOchYop[i]=false
        }
        animaDoing=false
        close(image_1,R.drawable.jahon3, 0)
        close(image_2,R.drawable.jahon4,0)
        close(image_3,R.drawable.jahon5,0)
        close(image_4,R.drawable.jahon5,0)
        close(image_5,R.drawable.jahon4,0)
        close(image_6,R.drawable.jahon3, 0)
        count=0
        image_1.visibility = View.VISIBLE
        image_2.visibility = View.VISIBLE
        image_3.visibility = View.VISIBLE
        image_4.visibility = View.VISIBLE
        image_5.visibility = View.VISIBLE
        image_6.visibility = View.VISIBLE


    }
}