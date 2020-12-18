package com.downloader.multithreaddownloader.view;

import com.downloader.multithreaddownloader.downloader.Downloader;
import com.downloader.multithreaddownloader.downloader.config.DownloaderConfig;

import static com.downloader.multithreaddownloader.utils.ParserUtils.parse;

import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;

public class MainViewFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = -6978845937417356763L;

    /**
     * Constructor
     */
    public MainViewFrame() {
	initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
	jLabel1 = new javax.swing.JLabel();
	jScrollPane1 = new javax.swing.JScrollPane();
	urlToBeParsedTextArea = new javax.swing.JTextArea();
	jLabel2 = new javax.swing.JLabel();
	jLabel3 = new javax.swing.JLabel();
	jLabel4 = new javax.swing.JLabel();
	numberOfDownloaderThreadsTextField = new javax.swing.JTextField();
	numberOfParserThreadsTextField = new javax.swing.JTextField();
	javax.swing.JButton startDownloadButton = new javax.swing.JButton();
	jLabel5 = new javax.swing.JLabel();
	jLabel6 = new javax.swing.JLabel();
	downloadLocationTextField = new javax.swing.JTextField();
	extensionsTextField = new javax.swing.JTextField();
	jLabel7 = new javax.swing.JLabel();
	imagesCheckBox = new javax.swing.JCheckBox();
	scriptsCheckBox = new javax.swing.JCheckBox();
	linksCheckBox = new javax.swing.JCheckBox();

	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
	jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	jLabel1.setText("MultiThreadDownloader");

	urlToBeParsedTextArea.setColumns(20);
	urlToBeParsedTextArea.setRows(5);
	urlToBeParsedTextArea.setText("https://unsplash.com/search/photos/sample\nhttps://www.pexels.com/");
	jScrollPane1.setViewportView(urlToBeParsedTextArea);

	jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
	jLabel2.setText("List with URL's to be parsed separated by newline");

	jLabel3.setText("Number of downloader threads");

	jLabel4.setText("Number of parser threads");

	numberOfDownloaderThreadsTextField.setText("5");
	numberOfDownloaderThreadsTextField.addKeyListener(new java.awt.event.KeyAdapter() {
	    public void keyTyped(java.awt.event.KeyEvent evt) {
		numberOfDownloaderThreadsTextFieldKeyTyped(evt);
	    }
	});

	numberOfParserThreadsTextField.setText("5");
	numberOfParserThreadsTextField.addKeyListener(new java.awt.event.KeyAdapter() {
	    public void keyTyped(java.awt.event.KeyEvent evt) {
		numberOfParserThreadsTextFieldKeyTyped(evt);
	    }
	});

	startDownloadButton.setText("Start Download");
	startDownloadButton.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
		startDownloadButtonActionPerformed(evt);
	    }
	});

	jLabel5.setText("Download Location");

	jLabel6.setText("Extensions list separated by semicolon");

	downloadLocationTextField.setText("E:\\DownloadManager");

	extensionsTextField.setText(".mkv;.mp4;.flv;.3gp;.png;.jpg;.jpeg;.js");

	jLabel7.setText("Type of parsing");

	imagesCheckBox.setSelected(true);
	imagesCheckBox.setText("Images");

	scriptsCheckBox.setSelected(true);
	scriptsCheckBox.setText("Scripts");

	linksCheckBox.setSelected(true);
	linksCheckBox.setText("Links");

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
		.createSequentialGroup().addGap(25, 25, 25)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addComponent(imagesCheckBox).addGap(18, 18, 18)
				.addComponent(scriptsCheckBox).addGap(18, 18, 18).addComponent(linksCheckBox))
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jScrollPane1)
				.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(numberOfDownloaderThreadsTextField,
							javax.swing.GroupLayout.PREFERRED_SIZE, 300,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(downloadLocationTextField,
							javax.swing.GroupLayout.PREFERRED_SIZE, 300,
							javax.swing.GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
						Short.MAX_VALUE)
					.addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 300,
							Short.MAX_VALUE)
						.addComponent(numberOfParserThreadsTextField)
						.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(extensionsTextField)))
				.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGap(146, 146, 146).addComponent(
					startDownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
					javax.swing.GroupLayout.PREFERRED_SIZE))))
		.addContainerGap(25, Short.MAX_VALUE)));
	layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
		.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
		.addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
			javax.swing.GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
			.addComponent(jLabel4))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(numberOfDownloaderThreadsTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(numberOfParserThreadsTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
			.addComponent(jLabel6))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(downloadLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			.addComponent(extensionsTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
			javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(imagesCheckBox).addComponent(scriptsCheckBox).addComponent(linksCheckBox))
		.addGap(18, 18, 18).addComponent(startDownloadButton).addContainerGap()));

	pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startDownloadButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_startDownloadButtonActionPerformed
	try {
	    boolean parseImages = imagesCheckBox.isSelected();
	    boolean parseScripts = scriptsCheckBox.isSelected();
	    boolean parseLinks = linksCheckBox.isSelected();
	    int numberOfParsingThreads = Integer.parseInt(numberOfParserThreadsTextField.getText());
	    int numberOfDownloaderThreads = Integer.parseInt(numberOfDownloaderThreadsTextField.getText());
	    String downloadLocation = downloadLocationTextField.getText();
	    Set<String> fileExtensions = parse(extensionsTextField.getText(), ";");
	    Set<String> urlToBeParsed = parse(urlToBeParsedTextArea.getText(), "[\\r\\n]+");
	    CountDownLatch countDownLatch = new CountDownLatch(numberOfDownloaderThreads);
	    DownloaderConfig downloaderConfig = new DownloaderConfig(countDownLatch, urlToBeParsed, fileExtensions, downloadLocation, numberOfParsingThreads, numberOfDownloaderThreads, parseImages, parseLinks, parseScripts);
	    Downloader downloader = new Downloader(downloaderConfig);
	    downloader.start();
	    countDownLatch.await();
	    JOptionPane.showMessageDialog(this, "All files was successfully downloaded.", "Success", JOptionPane.INFORMATION_MESSAGE);
	} catch (Exception ex) {
	    JOptionPane.showMessageDialog(this, "An error occured when we tried to download resources: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
    }// GEN-LAST:event_startDownloadButtonActionPerformed

    private void numberOfDownloaderThreadsTextFieldKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_numberOfDownloaderThreadsTextFieldKeyTyped
	char c = evt.getKeyChar();
	if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER)
		|| (c == KeyEvent.VK_TAB) || (Character.isDigit(c)))) {
	    evt.consume();
	}
    }// GEN-LAST:event_numberOfDownloaderThreadsTextFieldKeyTyped

    private void numberOfParserThreadsTextFieldKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_numberOfParserThreadsTextFieldKeyTyped
	char c = evt.getKeyChar();
	if (!((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER)
		|| (c == KeyEvent.VK_TAB) || (Character.isDigit(c)))) {
	    evt.consume();
	}
    }// GEN-LAST:event_numberOfParserThreadsTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField downloadLocationTextField;
    private javax.swing.JTextField extensionsTextField;
    private javax.swing.JCheckBox imagesCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox linksCheckBox;
    private javax.swing.JTextField numberOfDownloaderThreadsTextField;
    private javax.swing.JTextField numberOfParserThreadsTextField;
    private javax.swing.JCheckBox scriptsCheckBox;
    private javax.swing.JTextArea urlToBeParsedTextArea;
    // End of variables declaration//GEN-END:variables
}
