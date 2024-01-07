package ru.nsk.positiveteam.vkcode.core.data.aware.mapper;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface MapToAware<S, D> {
    D mapTo(S source);

    default List<D> mapTo(List<S> sourceList) {
        return sourceList.stream()
                .map(this::mapTo)
                .collect(Collectors.toList());
    }
}
