package com.self.practice.brs.dto.model.bus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StopDto implements Comparable<StopDto> {

    private String code;

    private String name;

    private String detail;


    @Override
    public int compareTo(StopDto o) {
        return Optional
                .ofNullable(this.getName())
                .map(n -> n.compareTo(o.getName()))
                .orElse(-1);
    }
}
