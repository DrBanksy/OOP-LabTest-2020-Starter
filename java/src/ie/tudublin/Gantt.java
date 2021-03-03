package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void displayTasks() {
		float cGap = 255 / (float) tasks.size();
		float newBorder = 50;

		float border = width * 0.1f;
		textAlign(CENTER, CENTER);
		colorMode(HSB);
		for(int i = 1; i <= 30;i++ ) {
			
			float x = map(i, 1, 30, border*2, width-(border/2));
			float y = map(i, 1, 30, border*2, height-border);
			fill(0, 0, 250);
			text(i, x,  (border/2) - 20);
			stroke(50);
			line(x,  (border/2), x, height - (border/2));
			
		}

		for(int i = 0; i < tasks.size();i++){
				Task task = tasks.get(i);
				fill(255);
				float x1 = map(task.getStart(),1, 30, border*2, width-(border/2));
				float x2 = map(task.getEnd(),1, 30, border*2, width-(border/2));
				println("x1: "  + x1 + " " + "x2" + x2);
				float temp = x2-x1;

				rect(x1,(newBorder * i) + 80, temp, 10);

		}

		for(int i = 0 ; i < tasks.size();i++) {
			Task task = tasks.get(i);
			text(task.getTask(), border, (newBorder * i) + 80);
		}
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row : table.rows() ) {
			// append to list 
			Task task = new Task(row);
			tasks.add(task);
		}
	}

	public void printTasks()
	{
		for(Task t : tasks) {
			println(t);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		// printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();

	}
}
