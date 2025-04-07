package domainstructure.domainstructure.core.user.type;

import lombok.Getter;

@Getter
public enum CityType {
    SEOUL("서울특별시"),
    BUSAN("부산광역시"),
    DAEGU("대구광역시"),
    INCHEON("인천광역시"),
    GWANGJU("광주광역시"),
    DAEJEON("대전광역시"),
    ULSAN("울산광역시"),
    SEJONG("세종특별자치시");

    private final String displayName;

    CityType(String displayName) {
        this.displayName = displayName;
    }

    public static CityType from(String value) {
        for (CityType city : values()) {
            if (city.displayName.equals(value)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Unknown city name: " + value);
    }

    @Override
    public String toString() {
        return displayName;
    }
}