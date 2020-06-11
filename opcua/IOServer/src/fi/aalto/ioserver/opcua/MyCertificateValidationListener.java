/*******************************************************************************
 * Copyright 2020 Information Technologies in Industrial Automation, Aalto Univeristy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package fi.aalto.ioserver.opcua;

import java.util.EnumSet;

import com.prosysopc.ua.stack.cert.CertificateCheck;
import com.prosysopc.ua.stack.cert.DefaultCertificateValidatorListener;
import com.prosysopc.ua.stack.cert.ValidationResult;
import com.prosysopc.ua.stack.core.ApplicationDescription;
import com.prosysopc.ua.stack.transport.security.Cert;

/**
 * MyCertificateValidationListener
 * 
 * CertificateValidationListener implementation used by the OPC UA server to
 * validate client certificates. Currently no validation is done and all
 * certificates are accepted.
 * 
 */
public class MyCertificateValidationListener implements DefaultCertificateValidatorListener {

	@Override
	public ValidationResult onValidate(Cert certificate, ApplicationDescription applicationDescription, EnumSet<CertificateCheck> passedChecks) {
		// Allow all certificates for now
		return ValidationResult.AcceptPermanently;
	}

}
