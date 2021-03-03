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
		colorMode(HSB);
		float border = width * 0.1f;
		for(int i = 1; i <= 30;i++ ) {
			float x = map(i, 1, 30, border, width-border);
			float y = map(i, 1, 30, border, height-border);
			stroke(255);
			fill(255);
			line(x, y, x, y);

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
		printTasks();
		displayTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}
