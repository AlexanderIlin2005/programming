package interfaces;

import enums.Gender;
import enums.Tense;
import objects.BaseObject;

public interface WordAgreementable {
    default String makeSentence(BaseObject object, String verb, Tense tense, String adding){
        return object.getName() + " " + tense.getStart() + (tense != Tense.NOW ? verb.substring(0, verb.length() - 2) : verb) +
                tense.getEnding() + (tense != Tense.NOW ? object.getGender().getEnding() : "") + " " + adding;
    }

    default String makeSentence(Gender gender, String verb, Tense tense, String adding){
        return tense.getStart() + (tense != Tense.NOW ? verb.substring(0, verb.length() - 2) : verb) +
                tense.getEnding() + (tense != Tense.NOW ? gender.getEnding() : "") + " " + adding;
    }



}
