package serrano.iccs.io;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClusterList {

	private List<Cluster> clusters;

	public List<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}

	@Override
	public String toString() {
		return "ClusterList [clusters=" + clusters + "]";
	}

}
