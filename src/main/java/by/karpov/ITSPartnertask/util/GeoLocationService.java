package by.karpov.ITSPartnertask.util;

import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

@Service()
public class GeoLocationService {
    private static DatabaseReader reader = null;
    private ResourceLoader resourceLoader;
    @Autowired
    public GeoLocationService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @PostConstruct
    public void init() throws IOException {
            Resource resource = resourceLoader.getResource("classpath:GeoLite2-City.mmdb");
            InputStream dbAsStream = resource.getInputStream();
            // Initialize the reader
            reader = new DatabaseReader
                    .Builder(dbAsStream)
                    .fileMode(Reader.FileMode.MEMORY)
                    .build();
    }

    public String findCountryNameByIp(String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = reader.city(ipAddress);
        return response.getCountry().getName();
    }

    public boolean isCountrySame(String roomCountry, String ip) throws IOException, GeoIp2Exception {
        return roomCountry.equals(findCountryNameByIp(ip));
    }

    @PreDestroy
    public void preDestroy() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
