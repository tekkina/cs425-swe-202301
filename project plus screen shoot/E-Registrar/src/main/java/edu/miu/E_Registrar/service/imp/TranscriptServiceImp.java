package edu.miu.E_Registrar.service.imp;

import edu.miu.E_Registrar.model.Transcript;
import edu.miu.E_Registrar.repository.TranscriptRepository;
import edu.miu.E_Registrar.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImp implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;
    @Override
    public Transcript addNewTranscript(Transcript newTranscript) {

        return transcriptRepository.save(newTranscript);
    }

    @Override
    public Transcript getTranscriptById(Integer transcriptId) {
        return transcriptRepository.findById(transcriptId).orElse(null);
    }
}
