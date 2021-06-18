package com.computershop.dao;

import java.util.HashMap;
//import java.util.Map;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.computershop.dao.product.CPU;
import com.computershop.dao.product.Case;
import com.computershop.dao.product.GraphicCard;
import com.computershop.dao.product.Monitor;
import com.computershop.dao.product.PowerSupply;
import com.computershop.dao.product.HardDisk;
import com.computershop.dao.product.Mainboard;
import com.computershop.dao.product.Ram;

@Entity
@Table(name = "OderItems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private SaleOrder saleOrder;

	@Column(name = "list_quantity_order", nullable = false) // neu goi constructor khong doi, list nay tu dong tao
	private HashMap<Object, Integer> listQuantityOrder;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "ram_id", nullable = true)
	private Ram ram;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "cpu_id", nullable = true)
	private CPU cpu;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "mainboard_id", nullable = true)
	private Mainboard mainboard;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "hard_disk_id", nullable = true)
	private HardDisk hardDisk;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "monitor_id", nullable = true)
	private Monitor monitor;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "power_supply_id", nullable = true)
	private PowerSupply powerSupply;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "case_id", nullable = true)
	private Case casepc;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "graphic_card_id", nullable = true)
	private GraphicCard graphicCard;

	public OrderItem(Long id, SaleOrder saleOrder, HashMap<Object, Integer> listQuantityOrder, Ram ram, CPU cpu,
			Mainboard mainboard, HardDisk hardDisk, Monitor monitor, PowerSupply powerSupply, Case casepc,
			GraphicCard graphicCard) {
		super();
		this.id = id;
		this.saleOrder = saleOrder;
		this.listQuantityOrder = listQuantityOrder;
		this.ram = ram;
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.hardDisk = hardDisk;
		this.monitor = monitor;
		this.powerSupply = powerSupply;
		this.casepc = casepc;
		this.graphicCard = graphicCard;
	}

	public OrderItem() {
		this.listQuantityOrder = new HashMap<Object, Integer>();
		if (this.ram != null)
			this.listQuantityOrder.put(this.ram, 0);

		if (this.cpu != null)
			this.listQuantityOrder.put(this.cpu, 0);

		if (this.mainboard != null)
			this.listQuantityOrder.put(this.mainboard, 0);

		if (this.hardDisk != null)
			this.listQuantityOrder.put(this.hardDisk, 0);

		if (this.monitor != null)
			this.listQuantityOrder.put(this.monitor, 0);

		if (this.powerSupply != null)
			this.listQuantityOrder.put(this.powerSupply, 0);

		if (this.casepc != null)
			this.listQuantityOrder.put(this.casepc, 0);

		if (this.graphicCard != null)
			this.listQuantityOrder.put(this.graphicCard, 0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SaleOrder getOrder() {
		return saleOrder;
	}

	public void setOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	public HashMap<Object, Integer> getListQuantityOrder() {
		return listQuantityOrder;
	}

	public void setListQuantityOrder(HashMap<Object, Integer> listQuantityOrder) {
		this.listQuantityOrder = listQuantityOrder;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Mainboard getMainboard() {
		return mainboard;
	}

	public void setMainboard(Mainboard mainboard) {
		this.mainboard = mainboard;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public PowerSupply getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(PowerSupply powerSupply) {
		this.powerSupply = powerSupply;
	}

	public Case getCasepc() {
		return casepc;
	}

	public void setCasepc(Case casepc) {
		this.casepc = casepc;
	}

	public GraphicCard getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(GraphicCard graphicCard) {
		this.graphicCard = graphicCard;
	}

}
