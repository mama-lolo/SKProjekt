package gui;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2d;

import java.awt.font.GlyphVector;
import java.util.Random;
import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import algorythms.AbstractSortingAlgorythm;
import algorythms.BubbleSort;
import algorythms.GnomeSort;
import algorythms.SelectionSort;
 
public class MainDisplay{

    protected static int max = 100;
    final static int HOEHE=800;
    final static int BREITE = 800;
    private static int amountValues;
    private static Integer [] data;
public void start(int amountValues) {
	this.amountValues=amountValues;
	
    try {
        Display.setDisplayMode(new DisplayMode(HOEHE,BREITE));
        Display.create();
    } catch (LWJGLException e) {
        e.printStackTrace();
        System.exit(0);
    }
 
      //Init-Code (OpneGL)
              glMatrixMode(GL_PROJECTION);
              glLoadIdentity();
              glOrtho(0,HOEHE,BREITE,0,1,-1);
              glMatrixMode(GL_MODELVIEW);    
      //Init-Algorythm
              randomizeData();
              
              Vector progress=new Vector();
              
              AbstractSortingAlgorythm x = new GnomeSort();
              
              x.sort(data, progress);
              int durchlauf =0;
              boolean done = false;
    while (!Display.isCloseRequested()&&!done) {
        GL11.glClearColor(0.4f,0.6f,0.2f,1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        glBegin(GL11.GL_QUADS);
        try{
        normalDarstellung((Integer[])progress.elementAt(durchlauf));
        durchlauf+=(int)(Math.log(amountValues)*amountValues/1000)+1;
        }catch(ArrayIndexOutOfBoundsException e ){
        	done = true;
        	durchlauf=progress.size()-1;
        	System.out.print("Reached the arrayend.");
        	normalDarstellung((Integer[])progress.elementAt(durchlauf));
        }
        glEnd();
        Display.update();
                
        //Events
        while(Keyboard.next()) {
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
                Display.destroy();
                System.exit(0);
                }
        }
    }
    
    try {
    	System.out.println("Reached sleep.");
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Display.destroy();
    System.exit(0);
    }
 
 


    private static void randomizeData() {
    	Random r = new Random();
    	data = new Integer[amountValues];
    	for(int i = 0;i<data.length;i++){
    		data[i]=r.nextInt(max)+1;
    	}
	
    }




	public static void main(String[] argv) {
        MainDisplay displayExample = new MainDisplay();
    
        displayExample.start(1000);
    }
    

    public static void normalDarstellung(Integer[]data){
        for(int i = 0; i<data.length;i++){            
            glVertex2d((i+1)*BREITE/data.length, HOEHE-data[i]*HOEHE/max);
            glVertex2d((i+1)*BREITE/data.length, HOEHE);
            glVertex2d(i*BREITE/data.length, HOEHE);
            glVertex2d(i*BREITE/data.length, HOEHE-data[i]*HOEHE/max);
            
        }
    }
}