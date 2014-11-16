import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sye.pr.core.clustering.kmeans.IKMeansClusteringMethod;
import com.sye.pr.core.clustering.kmeans.model.ICluster;
import com.sye.pr.core.clustering.kmeans.model.IKMeansModel;
import com.sye.pr.core.model.IPattern;
import com.sye.pr.core.utils.IPatternLoader;



/** 
 * This is an example of how to call the KMeans implementation provided in this application 
 * 
 * @author luis m flores
 * @version 1.0
 * @since 15-11-2014
 * 
 */

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String args[]){
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"app-config.xml");
		IPatternLoader pl = (IPatternLoader)appContext.getBean("patternLoader");
		
		Set<IPattern> patterns = pl.loadPatterns("/Luis/IRIS_Sin.csv");
		
		IKMeansClusteringMethod kmeansClusteringSvc = (IKMeansClusteringMethod)appContext.getBean("kmeansClusteringSvc");
		
		IKMeansModel kmeansModel = kmeansClusteringSvc.cluster(patterns, 3, 100);
		
		logger.info("Final Result: ");
		for(ICluster cluster: kmeansModel.getClusters()){
			logger.info("Cluster: " + cluster.getId());
			logger.info("Centroid: " + cluster.getCentroid());
			logger.info("Patterns: ");
			for(IPattern pattern : cluster.getPatterns()){
				logger.info(pattern);
			}
			
		}
		
	}
}
