import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wordCounter {  
    public static void main(String[] args) {  
        new Counter();
    }     
}

class Counter extends JFrame {
    JLabel l1, l2, result;
    JTextArea t1;
    JButton b; 
    
    public Counter() {
        
        l1 = new JLabel("Enter your paragraph below");
        t1 = new JTextArea(10, 50);
        b = new JButton("OK");
        l2 = new JLabel("The number of words are: ");
        result = new JLabel(""); 
        
        // Set text area properties
        t1.setLineWrap(true);  // Enable line wrapping
        t1.setWrapStyleWord(true);  // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(t1);  // Add JScrollPane for scrolling
        scrollPane.setPreferredSize(new Dimension(400, 150));  // Set size of the text area

        // Set font for components
        l1.setFont(new Font("Arial", Font.ITALIC, 20));
        t1.setFont(new Font("Arial", Font.PLAIN, 18));
        l2.setFont(new Font("Arial", Font.ITALIC, 20));
        result.setFont(new Font("Arial", Font.BOLD, 20));

        // Set layout panels
        JPanel inputPanel = new JPanel(new BorderLayout());  
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                
        // Add components to the panels
        inputPanel.add(l1, BorderLayout.NORTH);  // Add label at the top of the text area
        inputPanel.add(scrollPane, BorderLayout.CENTER);  // Add scrollable text area
        buttonPanel.add(b);  // Add button
        resultPanel.add(l2);  // Add label for result text
        resultPanel.add(result);  // Add label for displaying the result

        // Add panels to the frame
        setLayout(new BorderLayout());  // Use BorderLayout to control component placement
        add(inputPanel, BorderLayout.NORTH);  // Add input panel at the top
        add(buttonPanel, BorderLayout.CENTER);  // Add button panel in the center
        add(resultPanel, BorderLayout.SOUTH);  // Add result panel at the bottom

        // Action listener for the "OK" button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = t1.getText().trim();  // Get the text from the JTextArea and trim any extra spaces
                if (text.isEmpty()) {
                    result.setText("No text entered.");
                } else {
                    // Split the text by spaces and count words
                    String[] words = text.split("\\s+");
                    result.setText(String.valueOf(words.length));  // Display word count
                }
            }
        });

        // Frame settings
        setTitle("Word Counter");
        setSize(500, 400);
        setResizable(false);  // Prevent resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
