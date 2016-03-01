/**
 * redpen: a text inspection tool
 * Copyright (c) 2014-2015 Recruit Technologies Co., Ltd. and contributors
 * (see CONTRIBUTORS.md)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cc.redpen.validator.section;

import cc.redpen.model.Section;
import cc.redpen.validator.Validator;

/**
 * Validate paragraph number. If a section has paragraphs more than specified,
 * This validator reports it.
 */
final public class ParagraphNumberValidator extends Validator {
    public ParagraphNumberValidator() {
        super("max_num", 5); // Default maximum number of paragraphs in a section.
    }

    @Override
    public void validate(Section section) {
        int paragraphNumber = section.getNumberOfParagraphs();
        if (getInt("max_num") < paragraphNumber) {
            addLocalizedError(section.getJoinedHeaderContents(), paragraphNumber);
        }
    }
}
