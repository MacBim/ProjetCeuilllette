package fr.iutvalence.info.projet.s2.g17.photop.GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.regex.*;

import javax.imageio.ImageIO;


/**
 * Creates a window with a menu at the top of the window : </br>
 *  <table border=1>
 *  <tr>
 *  <th>file</th>
 *  <th>edition</th>
 *  <th>add</th>
 *  </tr>
 *  <tr>
 *  <td>openFile</td>
 *  <td>select</td>
 *  <td>shape :</br> circle, square, triangle, rectangle</td>
 *  </tr>
 *  <tr>
 *  <td>create</br> an Image(png,jpg,bmp)</td>
 *  <td>rotate</td>
 *  <td>text</td>
 *  </tr>
 *  <tr>
 *  <td>closeFile</td>
 *  <td></td>
 *  <td>frame</td>
 *  </tr>
 *  </table>
 *  @author bertholm
 */

//file               | edition          | add             
//-------------------|------------------|--------------  
//	openFile         |   rotate         |  	shape :       
//	create           |   select         |  		circle    
//	---------------- |                  |  		square    
//	closeFile        |                  |  		triangle  
//	                 |                  |  		rectangle 
//	                 |                  |  	text          
//                   |                  |   frame         
public class TopMenuBar extends JMenuBar implements ActionListener
{
	/**
	 * The main window
	 */
	  private JFrame window;
	  /**
	   * The menu bar of the window
	   */
	  private JMenuBar menuBar;
	  /**
	   * The current image
	   * This image is temporary created and doesn't exists as an "physical" image (like "test.png" )
	   */
	  private BufferedImage currentImage;
	  
	  /**
	   * The "File" menu item
	   */
	  private JMenu file;
	  /**
	   * The "Open file" menu item
	   */
	  private JMenuItem openFile;
	  /**
	   * The "Create" menu item
	   */
	  private JMenuItem create;
	  /**
	   * The "Close" menu item
	   */
	  private JMenuItem closeFile;
	  /**
	   * The "Save" menu item
	   */
	  private JMenuItem saveFile;
	  /**
	   * The "Edit" menu item
	   */
	  private JMenu edition;
	  /**
	   * The "Rotate" menu item
	   */
	  private JMenuItem rotate;
	  /**
	   * The "Select" menu item
	   */
	  private JMenuItem select;
	  
	  /**
	   * The "Add" menu item
	   */
	  private JMenu add;
	  /**
	   * The "Shape" menu item
	   */
	  private JMenu shape; 
	  /**
	   * The "Circle" menu item
	   */
	  private JMenuItem circle;
	  /**
	   * The "Square" menu item
	   */
	  private JMenuItem square;
	  /**
	   * The "Triangle" menu item
	   */
	  private JMenuItem triangle;
	  /**
	   * The "Rectangle" menu item
	   */
	  private JMenuItem rectangle;
	  /**
	   * The "Text" menu item
	   */
	  private JMenuItem text;
	  /**
	   * The "Frame" menu item 
	   */
	  private JMenuItem frame;

	  /**
	   * The "canvas"
	   */
	  private JLabel image;
	  /**
	   * The main panel
	   */
	  private JPanel panel;
	 

	  /**
	   * The topMenuBar class which represents the top menu bar of the frame
	   * @param window
	   */
	  public TopMenuBar(JFrame window)
	  {
		  	this.window = window;
		  	this.window.setTitle("Photop'");
		  	
		  	window.setLayout(new GridBagLayout());

	        this.panel = new JPanel();
	        this.panel.setLayout(new BorderLayout());
	        this.image = new JLabel("");
	        this.panel.add(this.image, BorderLayout.CENTER);
	        
	        this.window.add(this.panel, new GridBagConstraints());
		  	
	        
		  	this.menuBar= new JMenuBar();
		  	
			this.file = new JMenu("Fichier");
			this.openFile = new JMenuItem("Ouvrir fichier");
			this.create = new JMenuItem("Creer image");
			this.closeFile = new JMenuItem("Fermer");
			this.saveFile = new JMenuItem("Sauvegarder");
			 
			
			this.edition = new JMenu("Edition");
			this.rotate = new JMenuItem("Tourner");
			this.select = new JMenuItem("Selectionner");
			  
			  
			this.add = new JMenu("Ajouter");
			this.shape = new JMenu("Forme"); 
			this.circle = new JMenuItem("Rond");
			this.square = new JMenuItem("Carre");
			this.triangle = new JMenuItem("Triangle");
			this.rectangle = new JMenuItem("Rectangle");
			this.text = new JMenuItem("Texte");
			this.frame = new JMenuItem("Cadre");
			
			//menu file : 
		    //	openFile
		    //	create
			//-------------
		    //	closeFile
		    this.file.add(openFile);
		    this.file.add(create);
		    this.file.add(saveFile);	
		    //add separator
		    this.file.addSeparator();
		    this.file.add(closeFile);  
		    	    
		    //menu edition :
		    //	rotate
		    //	select
		    this.edition.add(rotate);
		    this.edition.add(select);
		    
		    //menu add :
		    //	shape : 
		    //		circle
		    //		square
		    //		triangle
		    //		rectangle
		    //	text
		    //frame
		    this.shape.add(circle);
		    this.shape.add(square);
		    this.shape.add(triangle);
		    this.shape.add(rectangle);
		    
		    this.add.add(shape);
		    this.add.add(text);
		    this.add.add(frame);
		    
		    //menubar :
		    //file | edition | add
		    this.menuBar.add(file);
		    this.menuBar.add(edition);
		    this.menuBar.add(add);
			

		    this.openFile.addActionListener(this);
		    this.create.addActionListener(this);
		    this.closeFile.addActionListener(this);
		    this.circle.addActionListener(this);
		    this.square.addActionListener(this);
		    this.rectangle.addActionListener(this);
		    this.triangle.addActionListener(this);
		    this.text.addActionListener(this);
		    this.frame.addActionListener(this);
		    this.saveFile.addActionListener(this);

			this.add(menuBar);
		 
	  }
	  
	  /**
	   * All the actions listeners
	   */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		JMenuItem selectedItem = (JMenuItem) event.getSource();

		if (selectedItem == this.openFile)
		{
			JFileChooser fileExplorer = new JFileChooser();
            int result = fileExplorer.showOpenDialog(null);
            
            if (result == JFileChooser.APPROVE_OPTION) 
            {
                File file = fileExplorer.getSelectedFile();
                try 
                {
                    this.image.setIcon(new ImageIcon(ImageIO.read(file)));
                    this.window.setSize(ImageIO.read(file).getWidth(),ImageIO.read(file).getHeight());
                    
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                return;
            }
		}
		if (selectedItem == this.create)
		{	
			int height = Integer.parseInt(new JOptionPane().showInputDialog(window,"Height ?"));
			int width = Integer.parseInt(new JOptionPane().showInputDialog(window,"Width ?"));
			
			BufferedImage emptyImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
			this.currentImage = emptyImage;
			for(int x=0; x< emptyImage.getWidth() ; x++)
			{
				for(int y=0; y<emptyImage.getHeight(); y++)
				{
					emptyImage.setRGB(x, y, Color.WHITE.getRGB());
				}
			}
			
			this.window.setSize(width+200,height);
			this.image.setIcon(new ImageIcon(this.currentImage));
		}
		
		if (selectedItem == this.circle)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			else
				System.out.println("circle");
			
			
		}
		
		if (selectedItem == this.square)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			else
				System.out.println("square");
		}
		
		if (selectedItem == this.rectangle)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			else
				System.out.println("rectangle");
		}
		
		if (selectedItem == this.triangle)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			else
				System.out.println("triangle");
		}
		
		if (selectedItem == this.text)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			// TODO 
		}
		
		if (selectedItem == this.frame)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			// TODO 
		}
		
		
		if (selectedItem == this.closeFile)
		{
			if (JOptionPane.showConfirmDialog(this.window, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.window.dispose();
			return;
		}
		if(selectedItem == this.saveFile)
		{
			if(this.image.getIcon() == null)
				JOptionPane.showMessageDialog(this.window, "No file selected");
			else 
			{
				 BufferedImage savedImage = this.currentImage;
				 try
				{
					JFileChooser directoryChooser = new JFileChooser();
					directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					String showInputDialog = JOptionPane.showInputDialog(window,"Name of the image ?");
					directoryChooser.showOpenDialog(window);
					String path = directoryChooser.getSelectedFile().getPath();
					System.out.println(path);
					ImageIO.write( this.currentImage, "PNG", new File(path+"/"+showInputDialog+".png"));
					JOptionPane.showMessageDialog(this.window, "Image "+showInputDialog+".png saved !");
				} 
				 catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 }
	}
}

