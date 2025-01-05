package com.adminPanel.app.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@ConfigurationProperties(prefix = "myapp") //all in small
//==>

@NoArgsConstructor
@AllArgsConstructor
public class Config {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    private Description description;

    @NoArgsConstructor
    @AllArgsConstructor
    public static  class Description{
        // why static ==> in memory and all object refere to it "no change"

        private  String title;
        private String  fullDescription;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFullDescription() {
            return fullDescription;
        }

        public void setFullDescription(String fullDescription) {
            this.fullDescription = fullDescription;
        }
    }


}