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

import br.ucsal.iot.model.DadosLixeira;

public class Grafico extends JFrame {

	private static final long serialVersionUID = 656583759885949289L;
	private JPanel contentPane;

	private List<Integer> resultsValuesCapacity;
	private List<Integer> resultsValuesGas;
	private List<Integer> timesMillis;
	private List<DadosLixeira> dadosList;

	public Grafico(List<Integer> resultsValuesCapacity, List<Integer> resultsValuesGas, List<Integer> timeMillis) {
		this.resultsValuesCapacity = new ArrayList<>();
		this.resultsValuesGas = new ArrayList<>();
		this.timesMillis = new ArrayList<>();
		this.resultsValuesCapacity = resultsValuesCapacity;
		this.resultsValuesGas = resultsValuesGas;
		this.timesMillis = timeMillis;

	}

	public Grafico(List<DadosLixeira> dadosList) {
		this.dadosList = dadosList;
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

		System.out.println("Registros decriptografados pelo servidor:");
		for (int i = 0; i < dadosList.size(); i++) {
			System.out.println(dadosList.get(i).getCapacidade() + "\n" + dadosList.get(i).getSensorGas() + "\n"
					+ dadosList.get(i).getSensorTemperatura() + "\n" + dadosList.get(i).getSensorMagnetismo() + "\n"
					+ dadosList.get(i).getPeriodo() + "\n");
		}

		List<Double> listCapacidade = new ArrayList<>();
		List<Double> listGas = new ArrayList<>();
		List<Double> listTemperatura = new ArrayList<>();
		List<Double> listMagnetismo = new ArrayList<>();

		for (int i = 0; i < dadosList.size(); i++) {
			double porcentagemCapacidade = (dadosList.get(i).getCapacidade() * 100d) / 334d;
			double porcentagemGas = (dadosList.get(i).getSensorGas() * 100d) / 750d;
			double porcentagemTemperatura = (dadosList.get(i).getSensorTemperatura() * 100d) / 129d;
			double porcentagemMagnetismo = (dadosList.get(i).getSensorMagnetismo() * 100d) / 1023d;

			listCapacidade.add(porcentagemCapacidade);
			listGas.add(porcentagemGas);
			listTemperatura.add(porcentagemTemperatura);
			listMagnetismo.add(porcentagemMagnetismo);
		}

		var dataser = new XYSeriesCollection();

		var casosCapacidades = new XYSeries("Capacidade detectada");
		var casosNiveisGas = new XYSeries("Nível de gás detectado");
		var casosTemperatura = new XYSeries("Temperatura detectada");
		var casosNiveisMagnetismo = new XYSeries("Nível de magnetismo detectado");

//		for (int i = 0; i < dadosList.size(); i++) {
//			casosCapacidades.add(dadosList.get(i).getPeriodo(), dadosList.get(i).getCapacidade());
//			casosNiveisGas.add(dadosList.get(i).getPeriodo(), dadosList.get(i).getSensorGas());
//			casosTemperatura.add(dadosList.get(i).getPeriodo(), dadosList.get(i).getSensorTemperatura());
//			casosNiveisMagnetismo.add(dadosList.get(i).getPeriodo(), dadosList.get(i).getSensorMagnetismo());
//		}

		for (int i = 0; i < dadosList.size(); i++) {
			casosCapacidades.add(dadosList.get(i).getPeriodo(), listCapacidade.get(i));
			casosNiveisGas.add(dadosList.get(i).getPeriodo(), listGas.get(i));
			casosTemperatura.add(dadosList.get(i).getPeriodo(), listTemperatura.get(i));
			casosNiveisMagnetismo.add(dadosList.get(i).getPeriodo(), listMagnetismo.get(i));
		}

		dataser.addSeries(casosCapacidades);
		dataser.addSeries(casosNiveisGas);
		dataser.addSeries(casosTemperatura);
		dataser.addSeries(casosNiveisMagnetismo);

		JFreeChart linha = ChartFactory.createXYLineChart("Registros capturados da lixeira inteligente", "Período",
				"Porcentagem (%)", dataser, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = linha.getXYPlot();

		var renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.CYAN);
		renderer.setSeriesStroke(0, new BasicStroke(1));
		renderer.setSeriesPaint(1, Color.RED);
		renderer.setSeriesStroke(1, new BasicStroke(1));
		renderer.setSeriesPaint(2, Color.GREEN);
		renderer.setSeriesStroke(2, new BasicStroke(1));
		renderer.setSeriesPaint(3, Color.MAGENTA);
		renderer.setSeriesStroke(3, new BasicStroke(1));

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

	public void criarGraficoLinhaExemplo() {
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		var dataser = new XYSeriesCollection();

		var casosCapacidade = new XYSeries("Capacidade detectada");
		var casosNiveisGas = new XYSeries("Nível de Gás detectado");

		if ((resultsValuesCapacity == null || resultsValuesCapacity.isEmpty())
				|| (timesMillis == null || timesMillis.isEmpty())) {
			JOptionPane.showMessageDialog(null, "Não existem dados para gerar o gráfico");
			return;
		}

		for (int i = 0; i < timesMillis.size(); i++) {
			casosCapacidade.add(timesMillis.get(i), resultsValuesCapacity.get(i));
			casosNiveisGas.add(timesMillis.get(i), resultsValuesGas.get(i));
		}

		dataser.addSeries(casosCapacidade);
		dataser.addSeries(casosNiveisGas);

		JFreeChart linha = ChartFactory.createXYLineChart("Registros capturados da lixeira inteligente", "Tempo",
				"Registros", dataser, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = linha.getXYPlot();

		var renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.CYAN);
		renderer.setSeriesStroke(0, new BasicStroke(1));
		renderer.setSeriesPaint(1, Color.RED);
		renderer.setSeriesStroke(1, new BasicStroke(1));

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
