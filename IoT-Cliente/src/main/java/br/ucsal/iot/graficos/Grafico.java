package br.ucsal.iot.graficos;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico extends JFrame {

	private static final long serialVersionUID = 656583759885949289L;
	private JPanel contentPane;

	private List<Integer> resultsValuesCapacity;
	private List<Integer> timesMillis;

	public Grafico(List<Integer> resultsValuesCapacity, List<Integer> timeMillis) {
		this.resultsValuesCapacity = new ArrayList<>();
		this.timesMillis = new ArrayList<>();
		this.resultsValuesCapacity = resultsValuesCapacity;
		this.timesMillis = timeMillis;

	}

	private void criarFrameGrafico() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 983, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		this.setVisible(true);
	}

	public void criarGraficoPizza() {

		DefaultPieDataset pizza = new DefaultPieDataset();

//		pizza.setValue("Quantidade de Linhas(LOC)", qtdLoc);

//			pizza.setValue("Quantidade de Classes", qtdClasses);

//			pizza.setValue("Quantidade de Métodos", qtdMetodos);

//			pizza.setValue("Quantidade de Comentários", qtdComentarios);

//		JFreeChart grafico = ChartFactory.createPieChart3D("Análise do arquivo " + nomeArquivo, pizza, true, true,
//				false);

//		PiePlot fatia = (PiePlot) grafico.getPlot();
//		fatia.setSectionPaint("Quantidade de Linhas(LOC)", Color.BLUE);
//		fatia.setSectionPaint("Quantidade de Classes", Color.CYAN);
//		fatia.setSectionPaint("Quantidade de Métodos", Color.BLACK);
//		fatia.setSectionPaint("Quantidade de Comentários", Color.WHITE);

//		ChartPanel painel = new ChartPanel(grafico);
//		criarFrameGrafico();
//		painel.setVisible(true);
//		add(painel);
	}

	public void criarGraficoBarrasVertical() {

		DefaultCategoryDataset barra = new DefaultCategoryDataset();

//		barra.setValue(qtdLoc, "Quantidade de linhas(LOC)", Math.round(porcentagemLoc) + "%");

//		barra.setValue(qtdClasses, "Quantidade de Classes", Math.round(porcentagemClasses) + "%");
//		barra.setValue(qtdMetodos, "Quantidade de Métodos", Math.round(porcentagemMetodos) + "%");
//		barra.setValue(qtdComentarios, "Quantidade de Comentários", Math.round(porcentagemComentarios) + "%");

//		JFreeChart grafico = ChartFactory.createBarChart("Análise do arquivo " + nomeArquivo, "Porcentagem(%)",
//				"Quantidade", barra, PlotOrientation.VERTICAL, true, true, false);

//		CategoryPlot barraItem = grafico.getCategoryPlot();
//		barraItem.getRenderer().setSeriesPaint(0, Color.BLUE);
//		barraItem.getRenderer().setSeriesPaint(1, Color.GREEN);
//		barraItem.getRenderer().setSeriesPaint(2, Color.ORANGE);
//		barraItem.getRenderer().setSeriesPaint(3, Color.RED);

//		ChartPanel painel = new ChartPanel(grafico);
//		criarFrameGrafico();
//		painel.setVisible(true);
//		add(painel);

	}

	public void criarGraficoBarrasHorizontal() {

		DefaultCategoryDataset barra = new DefaultCategoryDataset();

//		barra.setValue(qtdLoc, "Quantidade de linhas(LOC)", Math.round(porcentagemLoc) + "%");
//		barra.setValue(qtdClasses, "Quantidade de Classes", Math.round(porcentagemClasses) + "%");
//		barra.setValue(qtdMetodos, "Quantidade de Métodos", Math.round(porcentagemMetodos) + "%");
//		barra.setValue(qtdComentarios, "Quantidade de Comentários", Math.round(porcentagemComentarios) + "%");

//		JFreeChart grafico = ChartFactory.createBarChart("Análise do arquivo " + nomeArquivo, "Porcentagem(%)",
//				"Quantidade", barra, PlotOrientation.HORIZONTAL, true, true, false);

//		CategoryPlot barraItem = grafico.getCategoryPlot();
//		barraItem.getRenderer().setSeriesPaint(0, Color.BLACK);
//		barraItem.getRenderer().setSeriesPaint(1, Color.WHITE);
//		barraItem.getRenderer().setSeriesPaint(2, Color.GRAY);
//		barraItem.getRenderer().setSeriesPaint(3, Color.CYAN);

//		ChartPanel painel = new ChartPanel(grafico);

//		criarFrameGrafico();
//		painel.setVisible(true);
//		add(painel);

	}

	public void criarGraficoLinha() {
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		var dataser = new XYSeriesCollection();

		var casos = new XYSeries("Capacidade detectada");

		if ((resultsValuesCapacity == null || resultsValuesCapacity.isEmpty())
				|| (timesMillis == null || timesMillis.isEmpty())) {
			JOptionPane.showMessageDialog(null, "Não existem dados para gerar o gráfico");
			return;
		}

		for (int i = 0; i < resultsValuesCapacity.size(); i++) {
			casos.add(timesMillis.get(i), resultsValuesCapacity.get(i));
		}

		dataser.addSeries(casos);

		JFreeChart linha = ChartFactory.createXYLineChart("Capacidade do Lixo durante o dia", "Tempo", "Capacidade",
				dataser, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = linha.getXYPlot();

		var renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.CYAN);
		renderer.setSeriesStroke(0, new BasicStroke(1));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.BLACK);
		plot.setRangeGridlinesVisible(true);
		plot.setDomainGridlinesVisible(true);

		linha.getLegend().setFrame(BlockBorder.NONE);
		linha.setBackgroundPaint(Color.ORANGE);
		linha.getTitle().setPaint(Color.BLACK);

		Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 10);

		ChartFrame painel = new ChartFrame("Gráfico de Linhas", linha);
		painel.setFont(font);
		painel.setVisible(true);
		painel.setSize(1300, 800);
	}

}
