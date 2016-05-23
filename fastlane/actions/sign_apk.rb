module Fastlane
  module Actions
    module SharedValues
      SIGNED_APK_PATH = :SIGNED_APK_PATH
    end

    class SignApkAction < Action
      def self.run(params)
      
      unless params[:input_apk_path]
        UI.user_error!("Couldn't find '*release-unsigned.apk' file at path 'app/build/outputs/apk/'")
      end 

      sign_cmd = ["jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1"]
      sign_cmd << ["-keystore #{params[:keystore_path]}" ] if params[:keystore_path]
      sign_cmd << ["#{params[:input_apk_path]}"] if params[:input_apk_path]
      sign_cmd << ["#{params[:alias]}"] if params[:alias]

      unless params[:signed_apk_path].nil? || params[:signed_apk_path].empty?
        sign_cmd << ["-signedjar #{params[:signed_apk_path]}" ] if params[:signed_apk_path]
      else
        if !params[:input_apk_path].nil? && params[:input_apk_path].include?("unsigned")
          sign_cmd << ["-signedjar #{params[:input_apk_path].gsub('unsigned', 'signed')}"]
        end
      end

      sign_cmd << ["-keypass #{params[:keypass] ? params[:keypass] : params[:storepass]}"] if params[:keypass] || params[:storepass]
      sign_cmd << ["-storepass #{params[:storepass]}"] if params[:storepass]
      sign_cmd << ["-tsa #{params[:tsa]}"] if params[:tsa]
    
      Fastlane::Actions.sh(sign_cmd, log: true)

      end

      #####################################################
      # @!group Documentation
      #####################################################

      def self.description
        "Sign a Android apk with a java keystore"
      end

      def self.available_options 

        apk_path_default = Dir["*.apk"].last || Dir[File.join("app", "build", "outputs", "apk", "*release-unsigned.apk")].last

        [
          FastlaneCore::ConfigItem.new(key: :input_apk_path,
                                       env_name: "INPUT_APK_PATH",
                                       description: "Path to your APK file that you want to sign",
                                       default_value: Actions.lane_context[SharedValues::GRADLE_APK_OUTPUT_PATH] || apk_path_default,
                                       optional: true),
          FastlaneCore::ConfigItem.new(key: :signed_apk_path,
                                       env_name: "SIGNED_APK_PATH",
                                       description: "Path to the signed APK file",
                                       optional: true,
                                       is_string: true),
          FastlaneCore::ConfigItem.new(key: :keystore_path,
                                       env_name: "KEYSTORE_PATH",
                                       description: "Path to java keystore",
                                       optional: true,
                                       verify_block: proc do |value|
                                         UI.user_error!("Couldn't find keystore file at path '#{value}'") unless File.exist?(value)
                                       end),
          FastlaneCore::ConfigItem.new(key: :alias,
                                       env_name: "ALIAS",
                                       description: "The alias of 
                                       the certificate in the keystore to use to sign the apk",
                                       is_string: true),
          FastlaneCore::ConfigItem.new(key: :keypass,
                                       env_name: "KEY_PASS",
                                       description: "The password used to protect the private key of the keystore entry addressed by the alias specified. If not specified storepass will be used",
                                       optional:true,
                                       is_string: true),
          FastlaneCore::ConfigItem.new(key: :storepass,
                                       env_name: "STORE_PASS",
                                       description: "The password which is required to  access  the keystore",
                                       is_string: true),
          FastlaneCore::ConfigItem.new(key: :tsa,
                                       env_name: "TIME_STAMPING_AUTHORITHY",
                                       description: "The url of the Time Stamping Authority (TSA) used to timestamp the apk signing",
                                       optional:true,
                                       is_string: true)
        ]
      end

      def self.output
          ['SIGN_APK_PATH', 'Path to your APK file']
      end

      def self.authors
        "nomisRev"
      end

      def self.is_supported?(platform)
        platform == :android
      end
    end
  end
end