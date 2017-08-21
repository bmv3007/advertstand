package dto;

/**
 * Created by Maria on 19.08.2017.
 */
    public class Category implements java.io.Serializable {

        static final long serialVersionUID = 3260689382642549142L;


        private Long id;


        private String name;

        public Category() {

        }

        public Category(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static long getSerialversionuid() {
            return serialVersionUID;
        }

    }