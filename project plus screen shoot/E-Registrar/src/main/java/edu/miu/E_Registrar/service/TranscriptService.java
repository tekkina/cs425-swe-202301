package edu.miu.E_Registrar.service;

import edu.miu.E_Registrar.model.Transcript;

public interface TranscriptService {
    Transcript addNewTranscript(Transcript newTranscript);
    Transcript getTranscriptById(Integer transcriptId);
}
