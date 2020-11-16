package lukaszkutylowski.service;

import lukaszkutylowski.model.Payload;

import java.util.List;

public interface CompanyService {
    List<Payload> get();
    Payload save(Payload payload);
}
